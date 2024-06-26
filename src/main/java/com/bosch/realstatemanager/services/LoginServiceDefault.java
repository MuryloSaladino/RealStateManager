package com.bosch.realstatemanager.services;

import com.bosch.realstatemanager.exceptions.NotFoundException;
import com.bosch.realstatemanager.exceptions.UnauthorizedException;
import com.bosch.realstatemanager.interfaces.JwtTokenManager;
import com.bosch.realstatemanager.interfaces.LoginService;
import com.bosch.realstatemanager.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceDefault implements LoginService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtTokenManager jwtTokenManager;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();


    @Override
    public String login(String username, String password) {

        System.out.println(username + " " + password);

        var userQuery = userRepository.findByUsername(username);
        if(userQuery.isEmpty()) throw new NotFoundException();

        var match = encoder.matches(password, userQuery.get().getPassword());

        if(!match) throw new UnauthorizedException();

        Map<String, Object> claims = new HashMap<>();
        claims.put("admin", userQuery.get().isAdmin());

        return jwtTokenManager.buildToken(claims, userQuery.get().getUsername(), userQuery.get().getId());
    }
}
