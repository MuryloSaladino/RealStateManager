package com.bosch.realstatemanager.dto.user;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UserCreationPayload {

    private String username;

    private String password;

    private String name;

    private String email;

    private String phone;

    private Boolean admin;
}
