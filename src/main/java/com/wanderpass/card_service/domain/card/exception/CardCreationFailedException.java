package com.wanderpass.card_service.domain.card.exception;

import com.wanderpass.global.exception.BusinessException;
import com.wanderpass.global.type.StatusCode;

public class CardCreationFailedException extends BusinessException {
    public CardCreationFailedException(String message) {
        super(StatusCode.CONFLICT, message);
    }
}
