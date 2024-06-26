package com.bosch.realstatemanager.interfaces;

import io.jsonwebtoken.Jwt;

import java.util.Date;

public interface JwtTokenManager {
    String getToken(Long userId);
    String getToken(Long userId, Date expiration);
    Jwt<?,?> validateToken(String token);
}
