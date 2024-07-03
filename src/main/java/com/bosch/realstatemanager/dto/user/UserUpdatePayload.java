package com.bosch.realstatemanager.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class UserUpdatePayload {

    @Size(min = 4, message = "Username must have at least 4 characters")
    private String username;

    private String password;

    @Size(max = 255, message = "Name length cannot be above 255 characters")
    private String name;

    @Email(message = "Email must be valid")
    private String email;

    private String phone;

    private Boolean admin;
}
