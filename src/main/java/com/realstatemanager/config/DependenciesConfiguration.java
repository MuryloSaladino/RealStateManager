package com.realstatemanager.config;

import com.realstatemanager.interfaces.JwtTokenManager;
import com.realstatemanager.interfaces.LoginService;
import com.realstatemanager.interfaces.UserEntityService;
import com.realstatemanager.services.JwtTokenManagerService;
import com.realstatemanager.services.LoginServiceDefault;
import com.realstatemanager.services.UserEntityServiceDefault;
import com.realstatemanager.sessions.UserSession;
import org.springframework.context.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.context.WebApplicationContext;

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
    public BCryptPasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(); }

    @Bean @Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS) @Primary
    public UserSession userSession() { return new UserSession(null, false); }
}