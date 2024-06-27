package com.bosch.realstatemanager.interfaces;

import com.bosch.realstatemanager.exceptions.UnauthorizedException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;

import java.util.Date;
import java.util.Map;

public interface JwtTokenManager {
    Claims extractClaims(String token);
    boolean isTokenValid(String token);
    String buildToken(Map<String, Object> claims, String subject, Long userId);
}
