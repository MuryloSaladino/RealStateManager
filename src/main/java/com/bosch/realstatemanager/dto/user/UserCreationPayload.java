package com.bosch.realstatemanager.dto.user;

public class UserCreationPayload {

    public String username;
    public String password;
    public String name;
    public String email;
    public String phone;
    public boolean admin;

    public UserCreationPayload(String username, String password, String name, String email, String phone, boolean admin) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.admin = admin;
    }
}
