package com.bosch.realstatemanager.dto.user;

public record UserCreationPayload(
        String username,
        String password,
        String name,
        String email,
        String phone,
        boolean admin
) {}
