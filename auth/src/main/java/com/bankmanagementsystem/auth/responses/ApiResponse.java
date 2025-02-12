package com.bankmanagementsystem.auth.responses;

import lombok.Data;

@Data
public class ApiResponse<T> {
    private String status;
    private T data;
    private String message;

    public ApiResponse(String status, T data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public static <T> ApiResponse<T> success(T data, String message) {
        return new ApiResponse<>("success", data, message);
    }

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>("success", data, null);
    }

    public static <T> ApiResponse<T> error(T data, String message) {
        return new ApiResponse<>("error", data, message);
    }

    public static <T> ApiResponse<T> fail(T data, String message) {
        return new ApiResponse<>("fail", data, message);
    }

}
