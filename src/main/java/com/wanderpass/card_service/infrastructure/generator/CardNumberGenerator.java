package com.wanderpass.card_service.infrastructure.generator;

import com.wanderpass.card_service.domain.type.Currency;
import org.springframework.stereotype.Component;

public interface CardNumberGenerator {
    String generate(Currency currency);
}

