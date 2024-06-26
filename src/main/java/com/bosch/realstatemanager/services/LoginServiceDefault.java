package com.bosch.realstatemanager.services;

import com.bosch.realstatemanager.exceptions.NotFoundException;
import com.bosch.realstatemanager.interfaces.JwtTokenManager;
import com.bosch.realstatemanager.interfaces.LoginService;
import com.bosch.realstatemanager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class LoginServiceDefault implements LoginService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtTokenManager jwtTokenManager;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();


    @Override
    public String login(String email, String password) {

        var userQuery = userRepository.findByEmail(email);
        if(userQuery.isEmpty()) throw new NotFoundException();

        var match = encoder.matches(password, userQuery.get().getPassword());

        if(!match) throw new ResponseStatusException(HttpStatusCode.valueOf(401));

        return "jwtTokenManager.getToken(user.getId())";
    }
}
