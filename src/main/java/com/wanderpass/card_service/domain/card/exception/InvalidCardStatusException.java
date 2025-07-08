package com.wanderpass.card_service.domain.card.exception;

import com.wanderpass.global.exception.BusinessException;
import com.wanderpass.global.type.StatusCode;

public class InvalidCardStatusException extends BusinessException {
    public InvalidCardStatusException(String message) {
        super(StatusCode.BAD_REQUEST, message);
    }
}
