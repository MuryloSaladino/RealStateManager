package com.bosch.realstatemanager.dto.login;

public record LoginPayload(
        String password,
        String username
) {}
