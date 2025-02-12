package com.bankmanagementsystem.common.responses;

import java.util.Objects;

public class ApiErrorResponse<T> extends ApiResponse {

    private T error;
    private T stack;

    public ApiErrorResponse(String status, String message, T error, T stack) {
        super(status, message);
        this.error = error;
        this.stack = stack;
    }

    public static <T> ApiErrorResponse<T> errored(String message, T error, T stack) {
        return new ApiErrorResponse<>("error", message, error, stack);
    }

    public static <T> ApiErrorResponse<T> fail(String message, T error, T stack) {
        return new ApiErrorResponse<>("fail", message, error, stack);
    }

    public T getError() {
        return error;
    }

    public void setError(T error) {
        this.error = error;
    }

    public T getStack() {
        return stack;
    }

    public void setStack(T stack) {
        this.stack = stack;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof ApiErrorResponse))
            return false;
        ApiErrorResponse<?> that = (ApiErrorResponse<?>) o;
        return Objects.equals(getError(), that.getError()) && Objects.equals(getStack(), that.getStack());// +
    }

    @Override
    public int hashCode() {
        return Objects.hash(getError(), getStack());
    }

}
