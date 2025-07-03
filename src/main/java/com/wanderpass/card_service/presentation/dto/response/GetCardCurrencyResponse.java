package com.wanderpass.card_service.presentation.dto.response;

import com.wanderpass.card_service.domain.type.CardStatus;
import com.wanderpass.card_service.domain.type.Currency;

public record GetCardCurrencyResponse(
        Long cardId,
        Long memberId,
        Currency currency,
        CardStatus status
) {}
