package com.bankmanagementsystem.common.responses;

import java.util.Objects;

public class ApiSuccessResponse<T> extends ApiResponse {
    private T data;

    public ApiSuccessResponse(String status, T data, String message) {
        super(status, message);
        this.data = data;
    }

    public static <T> ApiResponse success(T data, String message) {
        return new ApiSuccessResponse<>("success", data, message);
    }

    public static <T> ApiSuccessResponse<T> success(T data) {
        return new ApiSuccessResponse<>("success", data, null);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof ApiSuccessResponse))
            return false;
        if (!super.equals(o))
            return false;
        ApiSuccessResponse<?> that = (ApiSuccessResponse<?>) o;
        return Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), data);
    }
}
