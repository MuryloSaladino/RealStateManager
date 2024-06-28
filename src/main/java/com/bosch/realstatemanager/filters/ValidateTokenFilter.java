package com.bosch.realstatemanager.filters;

import com.bosch.realstatemanager.exceptions.UnauthorizedException;
import com.bosch.realstatemanager.interfaces.JwtTokenManager;
import com.bosch.realstatemanager.sessions.UserSession;
import io.jsonwebtoken.Claims;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ValidateTokenFilter implements Filter {

    @Autowired
    JwtTokenManager jwtTokenManager;

    @Autowired
    UserSession userSession;

    @Override
    public void doFilter(
            ServletRequest servletRequest,
            ServletResponse servletResponse,
            FilterChain filterChain
    ) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

//        String token = request.getHeader("Authorization");

//        Claims claims = jwtTokenManager.extractClaims(token);

//        userSession.setId(Long.parseLong(claims.getId()));
//        userSession.setAdmin(claims.get("admin", Boolean.class));

        filterChain.doFilter(request, response);
    }
}
