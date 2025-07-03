package com.wanderpass.card_service.exception.card;

import com.wanderpass.global.type.BusinessException;
import com.wanderpass.global.type.StatusCode;

public class CardCreationFailedException extends BusinessException {
    public CardCreationFailedException(String message) {
        super(StatusCode.CONFLICT, message);
    }
}
