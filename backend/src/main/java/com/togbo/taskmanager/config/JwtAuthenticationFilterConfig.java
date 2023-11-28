package com.togbo.taskmanager.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

//OncePerRequestFilter -> creaza un filtru pentru ficare request
@Component
public class JwtAuthenticationFilterConfig extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(
            HttpServletRequest request, //is our request -> we can intercept every request and extract data from it
            HttpServletResponse response, //is our response -> after we intercept a request we can provide new response with new data
            FilterChain filterChain //is the chain of responsibility design pattern
    ) throws ServletException, IOException {
        final String authorizationHeader = request.getHeader("Authorization");
        final String jwtToken;

        if(authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        jwtToken = authorizationHeader.substring(7);
    }
}
