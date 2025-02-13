package com.bankmanagementsystem.auth.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JWTConfig {

    @Value("${jwt.secret}")
    private final String secretKey;

    @Value("${jwt.expiresIn}")
    private final long expiresIn;

    public JWTConfig(@Value("${jwt.secret}") String secretKey, @Value("${jwt.expiresIn}") long expiresIn) {
        this.secretKey = secretKey;
        this.expiresIn = expiresIn;
    }

    @Bean
    public String getSecret() {
        return secretKey;
    }

    @Bean
    public long getExpiration() {
        return expiresIn;
    }
}
