package com.boilerplate.utils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Omer Demirtas
 */
@Setter
@Getter
@ToString(exclude = { "data" })
@NoArgsConstructor
public class GenericResponse<T> {
    private T data;
    private String status;
    private String errorCode;
    private String errorMessage;

    public GenericResponse(StatusType statusType, T data) {
        this.data = data;
        this.status = statusType.toString();
    }

    public static <T> GenericResponse<T> success(T data) {
        return new GenericResponse<>(StatusType.SUCCESS, data);
    }

    public static <T> GenericResponse<T> success() {
        return new GenericResponse<>(StatusType.SUCCESS, null);
    }

    public static <T> GenericResponse<T> error(T data) {
        return new GenericResponse<>(StatusType.ERROR, data);
    }

    public static <T> GenericResponse<T> error() {
        return new GenericResponse<>(StatusType.ERROR, null);
    }

    public GenericResponse<T> errorCode(String errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    public GenericResponse<T> errorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }

    public enum StatusType {
        SUCCESS,
        ERROR
    }
}