package com.bankmanagementsystem.auth.responses;

import java.util.Objects;

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

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), token);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        AuthResponse<?> that = (AuthResponse<?>) o;
        return Objects.equals(token, that.token) && super.equals(o);
    }
}
