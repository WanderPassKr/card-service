package com.wanderpass.card_service.domain.card.presentation.dto.response;

import com.wanderpass.card_service.domain.card.domain.type.CardStatus;
import com.wanderpass.card_service.domain.card.domain.type.Currency;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class CreateCardResponse {
    private Long cardId;
    private String cardNumberMasked;
    private Currency currency;
    private BigDecimal balance;
    private CardStatus status;
}
