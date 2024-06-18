package com.bosch.realstatemanager.config;

import com.bosch.realstatemanager.interfaces.IDotenvService;
import com.bosch.realstatemanager.services.DotenvService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class DependenciesConfiguration {

    @Bean
    @Scope()
    public IDotenvService dotenvService() {
        return new DotenvService();
    }
}
