package com.bankmanagementsystem.auth.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordService {
    private final PasswordEncoder passwordEncoder;

    public PasswordService() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    // Encrypt password before saving to database
    public String encryptPassword(String plainPassword) {
        return passwordEncoder.encode(plainPassword);
    }

    // Compare plain password with encrypted password
    public boolean matches(String plainPassword, String encryptedPassword) {
        return passwordEncoder.matches(plainPassword, encryptedPassword);
    }

    // Example usage in authentication
    public boolean authenticateUser(String inputPassword, String storedHashedPassword) {
        if (inputPassword == null || storedHashedPassword == null) {
            return false;
        }
        return matches(inputPassword, storedHashedPassword);
    }
}
