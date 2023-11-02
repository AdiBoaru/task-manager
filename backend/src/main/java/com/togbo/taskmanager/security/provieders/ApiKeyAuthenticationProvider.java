package com.togbo.taskmanager.security.provieders;

import com.togbo.taskmanager.security.authentications.ApiKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class ApiKeyAuthenticationProvider implements AuthenticationProvider {
    @Value("$(api.key)")
    private String key;

    public ApiKeyAuthenticationProvider(String key) {
        this.key = key;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        ApiKey apiKey = (ApiKey) authentication;

        String keyValue = apiKey.getKey();

        if(key.equals(keyValue)){
            return new ApiKey(true, key);
        }

        throw new BadCredentialsException("Bad credentials");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return ApiKey.class.equals(authentication);
    }
}
