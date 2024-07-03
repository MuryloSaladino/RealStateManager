package com.bosch.realstatemanager.dto.user;

import com.bosch.realstatemanager.entities.UserEntity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class UserCreationPayload {

    @NotEmpty(message = "You must provide a username")
    @Size(min = 4, message = "Username must have at least 4 characters")
    private String username;

    @NotEmpty(message = "You must provide a password")
    private String password;

    @NotEmpty(message = "You must provide a name")
    @Size(max = 255, message = "Name length cannot be above 255 characters")
    private String name;

    @NotEmpty(message = "You must provide a email")
    @Email(message = "Email must be valid")
    private String email;

    @NotEmpty(message = "You must provide a phone")
    private String phone;

    private Boolean admin;

    public UserEntity toUser() {
        return new UserEntity(name, username, email, password, phone, admin);
    }
}
