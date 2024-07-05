package com.realstatemanager.filters;

import com.realstatemanager.interfaces.JwtTokenManager;
import com.realstatemanager.sessions.UserSession;
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

        String token = request.getHeader("Authorization");

        if(token != null) {
            token = token.replace("Bearer ", "");
            Claims claims = jwtTokenManager.extractClaims(token);

            userSession.setId(Long.parseLong(claims.getId()));
            userSession.setAdmin(claims.get("admin", Boolean.class));
        }

        filterChain.doFilter(request, response);
    }
}