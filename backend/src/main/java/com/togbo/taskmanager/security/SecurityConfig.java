package com.togbo.taskmanager.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.persistence.criteria.CriteriaBuilder;

@Configuration
@EnableWebSecurity //to tell spring this is where we keep the security configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
         http.csrf().disable()
                 .authorizeRequests()
                 .mvcMatchers(HttpMethod.GET, "/login/**")
                 .authenticated()
                 .and()
                 .httpBasic();

         return http.build();
    }


   /* @Bean
    public UserDetailsService userDetailsService(){
        UserDetailsService userDetailsService = new InMemoryUserDetailsManager();

        UserDetails userDetails = User.withUsername("user")
                .password("user");
    }

    */
}
