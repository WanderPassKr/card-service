package com.wanderpass.card_service.exception.card;

import com.wanderpass.global.type.BusinessException;
import com.wanderpass.global.type.StatusCode;

public class InvalidCardStatusException extends BusinessException {
    public InvalidCardStatusException(String message) {
        super(StatusCode.BAD_REQUEST, message);
    }
}
