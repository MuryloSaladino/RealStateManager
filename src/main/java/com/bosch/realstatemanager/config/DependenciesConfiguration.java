package com.bosch.realstatemanager.config;

import com.bosch.realstatemanager.interfaces.JwtTokenManager;
import com.bosch.realstatemanager.interfaces.LoginService;
import com.bosch.realstatemanager.interfaces.UserEntityService;
import com.bosch.realstatemanager.services.JwtTokenManagerService;
import com.bosch.realstatemanager.services.LoginServiceDefault;
import com.bosch.realstatemanager.services.db.UserEntityServiceDefault;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class DependenciesConfiguration {

    @Bean @Scope() @Primary
    public UserEntityService userEntityService() {
        return new UserEntityServiceDefault();
    }

    @Bean @Scope() @Primary
    public LoginService loginService() {
        return new LoginServiceDefault();
    }

    @Bean @Scope() @Primary
    public JwtTokenManager jwtTokenManager() {
        return new JwtTokenManagerService();
    }

    @Bean @Scope() @Primary
    BCryptPasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(); }


}
