package com.bankmanagementsystem.auth.controllers;

import com.bankmanagementsystem.auth.dto.UserDTO;
import com.bankmanagementsystem.auth.models.User;
import com.bankmanagementsystem.auth.responses.ApiResponse;
import com.bankmanagementsystem.auth.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/users")
@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public ResponseEntity<ApiResponse<UserDTO>> authenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User currentUser = (User) authentication.getPrincipal();
        UserDTO userDto = new UserDTO(currentUser.getId(), currentUser.getEmail(), currentUser.getName(),
                currentUser.getCreatedAt(), currentUser.getUpdatedAt());
        ApiResponse<UserDTO> response = ApiResponse.success(userDto);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> allUsers() {
        List<User> users = userService.allUsers();

        return ResponseEntity.ok(users);
    }
}