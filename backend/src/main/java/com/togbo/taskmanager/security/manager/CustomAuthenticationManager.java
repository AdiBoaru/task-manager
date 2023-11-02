package com.togbo.taskmanager.security.manager;

import com.togbo.taskmanager.security.provieders.CustomAuthenticationProvider;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class CustomAuthenticationManager implements AuthenticationManager {

    private CustomAuthenticationProvider provider;

    public CustomAuthenticationManager(CustomAuthenticationProvider customAuthenticationProvider) {
        this.provider = customAuthenticationProvider;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if(provider.supports(authentication.getClass())){
            return provider.authenticate(authentication);
        }
        throw new BadCredentialsException("Authentication Manager Failed");
    }
}

