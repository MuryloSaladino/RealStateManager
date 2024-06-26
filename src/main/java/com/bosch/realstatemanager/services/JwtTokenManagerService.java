package com.bosch.realstatemanager.services;

import com.bosch.realstatemanager.interfaces.JwtTokenManager;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtTokenManagerService implements JwtTokenManager {

//    private static final String secretKey = ;


}
