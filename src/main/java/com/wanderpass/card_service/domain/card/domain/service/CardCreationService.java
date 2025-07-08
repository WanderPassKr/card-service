package com.wanderpass.card_service.domain.card.domain.service;

import com.wanderpass.card_service.domain.card.domain.entity.Card;
import com.wanderpass.card_service.domain.card.domain.type.Currency;
import com.wanderpass.card_service.domain.card.exception.CardCreationFailedException;
import com.wanderpass.card_service.domain.card.infrastructure.generator.CardNumberGenerator;
import com.wanderpass.card_service.domain.card.infrastructure.persistence.CardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class CardCreationService {

    private final CardNumberGenerator generator;
    private final CardRepository cardRepository;

    @Transactional
    public Card createCardWithRetry(Long memberId, Currency currency) {
        int maxAttempts = 5;

        for (int i = 0; i < maxAttempts; i++) {
            String number = generator.generate(currency);
            Card card = Card.create(memberId, number, currency);

            try {
                return cardRepository.save(card);
            } catch (DataIntegrityViolationException e) {
                log.warn("카드 번호 중복 발생. 재시도 중... ({}/{})", i + 1, maxAttempts);
            }
        }

        throw new CardCreationFailedException("카드 번호 생성 실패: 중복으로 인한 생성 불가");
    }
}

