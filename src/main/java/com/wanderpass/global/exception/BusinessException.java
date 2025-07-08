package com.wanderpass.global.exception;

import com.wanderpass.global.type.StatusCode;
import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

    private final StatusCode statusCode;

    public BusinessException(StatusCode statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
    }
}
