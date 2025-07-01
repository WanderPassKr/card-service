package com.wanderpass.card_service.presentation.dto.request;

import com.wanderpass.card_service.domain.type.Currency;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CreateCardRequest {
    private Long memberId;
    private Currency currency;
}
