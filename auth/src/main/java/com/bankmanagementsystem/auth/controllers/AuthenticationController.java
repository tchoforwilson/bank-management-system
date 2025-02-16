package com.bankmanagementsystem.auth.controllers;

import com.bankmanagementsystem.auth.models.User;
import com.bankmanagementsystem.auth.dto.LoginUserDTO;
import com.bankmanagementsystem.auth.dto.RegisterUserDTO;
import com.bankmanagementsystem.auth.dto.UserDTO;
import com.bankmanagementsystem.auth.responses.AuthResponse;
import com.bankmanagementsystem.auth.services.AuthenticationService;
import com.bankmanagementsystem.auth.services.JWTService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/auth")
@RestController
public class AuthenticationController {
    private final JWTService jwtService;

    private final AuthenticationService authenticationService;

    public AuthenticationController(JWTService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse<UserDTO>> register(@RequestBody RegisterUserDTO registerUserDto) {

        User registeredUser = authenticationService.register(registerUserDto);
        String jwtToken = jwtService.generateToken(registeredUser);

        UserDTO userDto = authenticationService.mapToDTO(registeredUser);
        AuthResponse<UserDTO> authResponse = AuthResponse.success(jwtToken, userDto, "Register successfully");

        return ResponseEntity.ok(authResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse<UserDTO>> authenticate(@RequestBody LoginUserDTO loginUserDto) {
        User authenticatedUser = authenticationService.authenticate(loginUserDto);

        UserDTO userDto = authenticationService.mapToDTO(authenticatedUser);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        AuthResponse<UserDTO> authResponse = AuthResponse.success(jwtToken, userDto, "Login successful");

        return ResponseEntity.ok(authResponse);
    }

}