package com.wanderpass.card_service.exception.card;

import com.wanderpass.global.type.BusinessException;
import com.wanderpass.global.type.StatusCode;

public class CardNotFoundException extends BusinessException {
    public CardNotFoundException(String message) {
        super(StatusCode.NOT_FOUND, message);
    }
}
