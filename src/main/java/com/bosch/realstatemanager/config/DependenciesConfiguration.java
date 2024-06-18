package com.bosch.realstatemanager.config;

import com.bosch.realstatemanager.interfaces.IDotenvService;
import com.bosch.realstatemanager.interfaces.dbservices.IUserEntityService;
import com.bosch.realstatemanager.services.DotenvService;
import com.bosch.realstatemanager.services.dbservices.UserEntityServiceDefault;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
public class DependenciesConfiguration {

    @Bean @Scope()
    public IDotenvService dotenvService() {
        return new DotenvService();
    }

    @Bean @Scope() @Primary
    public IUserEntityService userEntityService() {
        return new UserEntityServiceDefault();
    }
}
