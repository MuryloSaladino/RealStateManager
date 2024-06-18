package com.bosch.realstatemanager.services;

import com.bosch.realstatemanager.interfaces.IJwtTokenManager;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtTokenManager implements IJwtTokenManager {

    private static final SecretKey secretKey = Jwts.SIG.HS256.key().build();

    @Override
    public String getToken(Long userId) {
        return Jwts.builder().id(userId.toString()).signWith(secretKey).compact();
    }

    @Override
    public String getToken(Long userId, Date expiration) {
        return Jwts.builder().id(userId.toString()).expiration(expiration).signWith(secretKey).compact();
    }

    @Override
    public Jwt<?,?> validateToken(String token) {

        Jwt<?,?> jwt;

        try {
            jwt = Jwts.parser().verifyWith(secretKey).build().parse(token);
        } catch (JwtException e) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(401));
        }

        return jwt;
    }
}
