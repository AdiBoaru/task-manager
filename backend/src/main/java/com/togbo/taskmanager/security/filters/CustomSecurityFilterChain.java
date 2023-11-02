package com.togbo.taskmanager.security.filters;

import com.togbo.taskmanager.security.authentications.CustomAuthentication;
import com.togbo.taskmanager.security.manager.CustomAuthenticationManager;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class CustomSecurityFilterChain extends OncePerRequestFilter {

    private CustomAuthenticationManager customAuthenticationManager;

    public CustomSecurityFilterChain(CustomAuthenticationManager customAuthenticationManager) {
        this.customAuthenticationManager = customAuthenticationManager;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String key = request.getHeader("key");
        CustomAuthentication customAuthentication = new CustomAuthentication(false, key);

        if(customAuthentication.isAuthenticate()){
            SecurityContextHolder.getContext().setAuthentication(customAuthentication);
            filterChain.doFilter(request, response);
        }
    }
}
