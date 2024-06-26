package com.bosch.realstatemanager.dto.login;

public class LoginPayload {

    public String password;
    public String email;

    public LoginPayload(String password, String email) {
        this.password = password;
        this.email = email;
    }
}
