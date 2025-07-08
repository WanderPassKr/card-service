package com.wanderpass.card_service.domain.card.presentation.dto.response;

import com.wanderpass.card_service.domain.card.domain.type.CardStatus;
import com.wanderpass.card_service.domain.card.domain.type.Currency;

public record GetCardCurrencyResponse(
        Long cardId,
        Long memberId,
        Currency currency,
        CardStatus status
) {}
