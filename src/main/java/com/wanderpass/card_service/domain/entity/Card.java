package com.wanderpass.card_service.domain.entity;

import com.wanderpass.card_service.domain.type.CardStatus;
import com.wanderpass.card_service.domain.type.Currency;
import com.wanderpass.card_service.exception.card.InvalidCardStatusChangeException;
import com.wanderpass.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "card")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Card extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "member_id", nullable = false)
    private Long memberId;

    @Column(name = "card_number", nullable = false, unique = true, length = 16)
    private String cardNumber;

    @Column(name = "balance", nullable = false)
    private BigDecimal balance;

    @Column(name = "hold_balance", nullable = false)
    private BigDecimal holdBalance;

    @Enumerated(EnumType.STRING)
    @Column(name = "currency", nullable = false)
    private Currency currency;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private CardStatus status;

    @Builder(access = AccessLevel.PRIVATE)
    private Card(Long memberId, String cardNumber, BigDecimal balance, BigDecimal holdBalance,
                 Currency currency, CardStatus status) {
        this.memberId = memberId;
        this.cardNumber = cardNumber;
        this.balance = balance;
        this.holdBalance = holdBalance;
        this.currency = currency;
        this.status = status;
    }

    // 정적 팩토리 메서드
    public static Card create(Long memberId, String cardNumber, Currency currency) {
        return Card.builder()
                .memberId(memberId)
                .cardNumber(cardNumber)
                .balance(BigDecimal.ZERO)
                .holdBalance(BigDecimal.ZERO)
                .currency(currency)
                .status(CardStatus.ACTIVE)
                .build();
    }

    public void changeStatus(CardStatus newStatus, String reason) {
        if (this.status.equals(newStatus)) {
            throw new InvalidCardStatusChangeException("카드는 이미 상태가 " + newStatus + "입니다.");
        }
        CardStatus oldStatus = this.status;
        this.status = newStatus;
    }

    public void holdAmount(BigDecimal amount) {
        this.holdBalance = this.holdBalance.add(amount);
    }

    public void releaseHold(BigDecimal amount) {
        this.holdBalance = this.holdBalance.subtract(amount);
    }

    public void decreaseBalance(BigDecimal amount) {
        this.balance = this.balance.subtract(amount);
    }

    public BigDecimal getRealBalance() {
        return this.balance.subtract(this.holdBalance);
    }
}