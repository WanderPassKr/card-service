package com.wanderpass.card_service.domain.card.exception;

import com.wanderpass.global.exception.BusinessException;
import com.wanderpass.global.type.StatusCode;

public class CardNotFoundException extends BusinessException {
    public CardNotFoundException(String message) {
        super(StatusCode.NOT_FOUND, message);
    }
}
