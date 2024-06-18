package com.bosch.realstatemanager.services;

import com.bosch.realstatemanager.interfaces.IDotenvService;
import io.github.cdimascio.dotenv.Dotenv;

public class DotenvService implements IDotenvService {

    private final Dotenv dotenv = Dotenv.configure()
        .directory("")
        .filename("env")
        .load();

    public String getEnv(String key) {
        return dotenv.get(key);
    }
}
