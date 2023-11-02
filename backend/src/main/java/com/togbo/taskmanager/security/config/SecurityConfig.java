package com.togbo.taskmanager.security.config;

import com.togbo.taskmanager.security.filters.CustomSecurityFilterChain;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {
    private CustomSecurityFilterChain customSecurityFilterChain;

    public SecurityConfig(CustomSecurityFilterChain customSecurityFilterChain) {
        this.customSecurityFilterChain = customSecurityFilterChain;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .addFilterAt(customSecurityFilterChain, UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .build();
    }

}
