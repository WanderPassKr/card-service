package com.wanderpass.card_service.domain.card.infrastructure.generator;

import com.wanderpass.card_service.domain.card.domain.type.Currency;

public interface CardNumberGenerator {
    String generate(Currency currency);
}

