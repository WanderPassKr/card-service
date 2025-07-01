package com.wanderpass.global.type;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

    private final StatusCode statusCode;

    public BusinessException(StatusCode statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
    }
}
