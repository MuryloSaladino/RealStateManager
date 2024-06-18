package com.bosch.realstatemanager.services.dbservices;

import com.bosch.realstatemanager.interfaces.IJwtTokenManager;
import com.bosch.realstatemanager.interfaces.dbservices.ILoginService;
import com.bosch.realstatemanager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class LoginServiceDefault implements ILoginService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private IJwtTokenManager jwtTokenManager;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();


    @Override
    public String login(String email, String password) {

        var user = userRepository.findByEmail(email);

        if(user == null) throw new ResponseStatusException(HttpStatusCode.valueOf(401));

        var match = encoder.matches(password, user.getPassword());

        if(!match) throw new ResponseStatusException(HttpStatusCode.valueOf(401));

        return jwtTokenManager.getToken(user.getId());
    }
}
