package com.togbo.taskmanager.security.manager;

import com.togbo.taskmanager.security.authentications.ApiKey;
import com.togbo.taskmanager.security.provieders.ApiKeyAuthenticationProvider;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class ApiKeyAuthenticationManager implements AuthenticationManager {

    private final ApiKeyAuthenticationProvider apiKeyProvider;

    public ApiKeyAuthenticationManager(ApiKeyAuthenticationProvider apiKeyProvider) {
        this.apiKeyProvider = apiKeyProvider;
    }


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if(apiKeyProvider.supports(authentication.getClass())){
            return apiKeyProvider.authenticate(authentication);
        }
        throw new BadCredentialsException("Bad Authentication Manager");
    }
}
