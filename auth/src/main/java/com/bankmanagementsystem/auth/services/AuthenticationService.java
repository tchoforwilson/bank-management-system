package com.bankmanagementsystem.auth.services;

import com.bankmanagementsystem.auth.dto.LoginUserDTO;
import com.bankmanagementsystem.auth.dto.RegisterUserDTO;
import com.bankmanagementsystem.auth.dto.UserDTO;
import com.bankmanagementsystem.auth.models.User;
import com.bankmanagementsystem.auth.repositories.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
            UserRepository userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDTO mapToDTO(User user) {
        return new UserDTO(user.getId(), user.getEmail(), user.getName(), user.getCreatedAt(), user.getUpdatedAt());
    }

    public User mapToEntity(UserDTO userDTO) {
        return new User(userDTO.getName(), userDTO.getEmail());
    }

    public User register(RegisterUserDTO input) {
        User user = new User(input.getName(), input.getEmail(), passwordEncoder.encode(input.getPassword()));

        return userRepository.save(user);
    }

    public User authenticate(LoginUserDTO input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()));

        return userRepository.findByEmail(input.getEmail())
                .orElseThrow();
    }
}