package com.bosch.realstatemanager.services;

import com.bosch.realstatemanager.exceptions.UnauthorizedException;
import com.bosch.realstatemanager.interfaces.JwtTokenManager;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.Map;

@Service
public class JwtTokenManagerService implements JwtTokenManager {

    @Value("${security.jwt.secret-key}")
    private String secretKey;

    @Value("${security.jwt.expiration-time}")
    private Long expirationTime;

    private SecretKey getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String buildToken(Map<String, Object> claims, String subject, Long userId) {
        return Jwts
                .builder()
                .subject(subject)
                .id(userId.toString())
                .claims(claims)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(getSignInKey())
                .compact();
    }

    public Claims extractClaims(String token) throws UnauthorizedException {
        try {
            return Jwts
                    .parser()
                    .verifyWith(getSignInKey())
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
        } catch (JwtException e) {
            throw new UnauthorizedException();
        }
    }

    public boolean isTokenValid(String token) {
        return extractClaims(token).getExpiration().before(new Date());
    }
}
