package com.wanderpass.card_service.domain.card.exception;

import com.wanderpass.global.exception.BusinessException;
import com.wanderpass.global.type.StatusCode;

public class InvalidCardStatusChangeException extends BusinessException {
    public InvalidCardStatusChangeException(String message) {
      super(StatusCode.CONFLICT , message);
    }
}
