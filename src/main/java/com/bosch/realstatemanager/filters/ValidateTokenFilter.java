package com.bosch.realstatemanager.filters;

import com.bosch.realstatemanager.exceptions.UnauthorizedException;
import com.bosch.realstatemanager.interfaces.JwtTokenManager;
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

    @Override
    public void doFilter(
            ServletRequest servletRequest,
            ServletResponse servletResponse,
            FilterChain filterChain
    ) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String token = request.getHeader("Authorization");

        if(!jwtTokenManager.isTokenValid(token)) throw new UnauthorizedException();
    }
}
