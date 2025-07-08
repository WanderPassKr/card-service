package com.wanderpass.card_service.domain.card.presentation.controller;

import com.wanderpass.card_service.domain.card.application.CardService;
import com.wanderpass.card_service.domain.card.presentation.dto.request.CreateCardRequest;
import com.wanderpass.card_service.domain.card.presentation.dto.response.CreateCardResponse;
import com.wanderpass.card_service.domain.card.presentation.dto.response.GetCardCurrencyResponse;
import com.wanderpass.global.dto.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cards")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    @PostMapping
    public ResponseEntity<ApiResponse<CreateCardResponse>> createCard(@RequestBody CreateCardRequest request) {
        CreateCardResponse response = cardService.createCard(request);
        return ResponseEntity.ok(ApiResponse.success(response));
    }

    @GetMapping("/{cardId}/currency")
    public ResponseEntity<ApiResponse<GetCardCurrencyResponse>> getCardCurrency(@PathVariable Long cardId) {
        GetCardCurrencyResponse response = cardService.getCardCurrency(cardId);
        return ResponseEntity.ok(ApiResponse.success(response));
    }
}
