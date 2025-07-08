package com.wanderpass.card_service.domain.card.application;

import com.wanderpass.card_service.domain.card.domain.entity.Card;
import com.wanderpass.card_service.domain.card.domain.service.CardCreationService;
import com.wanderpass.card_service.domain.card.domain.type.CardStatus;
import com.wanderpass.card_service.domain.card.infrastructure.persistence.CardRepository;
import com.wanderpass.card_service.domain.card.presentation.dto.request.CreateCardRequest;
import com.wanderpass.card_service.domain.card.presentation.dto.response.CreateCardResponse;
import com.wanderpass.card_service.domain.card.presentation.dto.response.GetCardCurrencyResponse;
import com.wanderpass.card_service.domain.card.exception.CardNotFoundException;
import com.wanderpass.card_service.domain.card.exception.InvalidCardStatusException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CardService {

    private final CardCreationService cardCreationService;
    private final CardRepository cardRepository;

    public CreateCardResponse createCard(CreateCardRequest request) {
        Card card = cardCreationService.createCardWithRetry(request.getMemberId(), request.getCurrency());

        String maskedNumber = maskCardNumber(card.getCardNumber());

        return new CreateCardResponse(
                card.getId(),
                maskedNumber,
                card.getCurrency(),
                card.getBalance(),
                card.getStatus()
        );
    }

    private String maskCardNumber(String cardNumber) {
        if (cardNumber.length() < 10) return "************";
        return cardNumber.substring(0, 6) + "******" + cardNumber.substring(cardNumber.length() - 4);
    }

    public GetCardCurrencyResponse getCardCurrency(Long cardId) {
        Card card = cardRepository.findById(cardId)
                .orElseThrow(() -> new CardNotFoundException("카드를 찾을 수 없습니다."));

        if (card.getStatus() != CardStatus.ACTIVE) {
            throw new InvalidCardStatusException("사용 불가능한 카드입니다.");
        }

        return new GetCardCurrencyResponse(card.getId(), card.getMemberId(), card.getCurrency(), card.getStatus());
    }
}
