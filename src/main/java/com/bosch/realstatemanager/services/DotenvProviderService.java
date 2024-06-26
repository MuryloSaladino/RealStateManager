package com.bosch.realstatemanager.services;

import com.bosch.realstatemanager.interfaces.DotenvProvider;
import io.github.cdimascio.dotenv.Dotenv;

public class DotenvProviderService implements DotenvProvider {

    private final Dotenv dotenv = Dotenv.configure()
        .directory("")
        .filename("env")
        .load();

    public String getEnv(String key) {
        return dotenv.get(key);
    }
}
