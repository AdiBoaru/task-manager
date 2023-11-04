package com.togbo.taskmanager.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.httpBasic()
                .and()
                .anyHttpRequest().permiteAll()
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();

        UserDetails userDetails = User.withUsername("bill")
                .password(passwordEncoder().encode("12345"))
                .authorities("read")
                .build();



        UserDetails userDetails1 = User.withUsername("adi")
                .password(passwordEncoder().encode("1234"))
                .authorities("adi")
                .build();

        userDetailsManager.createUser(userDetails);
        userDetailsManager.createUser(userDetails1);

        return userDetailsManager;
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
