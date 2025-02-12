package com.bankmanagementsystem.auth.responses;

import lombok.Data;

@Data
public class AuthResponse<T> extends ApiResponse<T> {
    private String token;

    public AuthResponse(String status, String token, T data, String message) {
        super(status, data, message);
        this.token = token;
    }

    public static <T> AuthResponse<T> success(String token, T data, String message) {
        return new AuthResponse<>("success", token, data, message);
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
