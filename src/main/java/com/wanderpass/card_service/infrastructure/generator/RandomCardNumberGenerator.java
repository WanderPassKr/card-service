package com.wanderpass.card_service.infrastructure.generator;

import com.wanderpass.card_service.domain.type.Currency;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RandomCardNumberGenerator implements CardNumberGenerator {

    @Override
    public String generate(Currency currency) {
        String prefix = switch (currency) {
            case JPY -> "81";
            case USD -> "1";
            case KRW -> "82";
            default -> "99";
        };
        String randomDigits = UUID.randomUUID().toString().replaceAll("[^\\d]", "").substring(0, 14);
        return prefix + randomDigits;
    }
}

