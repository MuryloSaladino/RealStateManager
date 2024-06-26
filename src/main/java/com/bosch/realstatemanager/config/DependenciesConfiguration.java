package com.bosch.realstatemanager.config;

import com.bosch.realstatemanager.interfaces.DotenvProvider;
import com.bosch.realstatemanager.interfaces.JwtTokenManager;
import com.bosch.realstatemanager.interfaces.dbservices.ILoginService;
import com.bosch.realstatemanager.interfaces.dbservices.IUserEntityService;
import com.bosch.realstatemanager.services.DotenvProviderService;
import com.bosch.realstatemanager.services.JwtTokenManagerService;
import com.bosch.realstatemanager.services.dbservices.LoginServiceDefault;
import com.bosch.realstatemanager.services.dbservices.UserEntityServiceDefault;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
public class DependenciesConfiguration {

    @Bean @Scope()
    public DotenvProvider dotenvService() {
        return new DotenvProviderService();
    }

    @Bean @Scope() @Primary
    public IUserEntityService userEntityService() {
        return new UserEntityServiceDefault();
    }

    @Bean @Scope() @Primary
    public ILoginService loginService() {
        return new LoginServiceDefault();
    }

    @Bean @Scope() @Primary
    public JwtTokenManager jwtTokenManager() {
        return new JwtTokenManagerService();
    }
}
