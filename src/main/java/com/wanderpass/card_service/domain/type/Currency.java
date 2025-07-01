package com.wanderpass.card_service.domain.type;

/**
 * 기준 통화를 나타내는 열거형입니다.
 * 실제 시스템에서는 외부 API 기준에 따라 확장 가능합니다.
 */
public enum Currency {
    KRW,   // 대한민국 원
    JPY,   // 일본 엔
    USD,   // 미국 달러
    EUR,   // 유로
    GBP,   // 영국 파운드
    CNY    // 중국 위안
}

