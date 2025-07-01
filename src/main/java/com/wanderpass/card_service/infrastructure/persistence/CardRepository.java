package com.wanderpass.card_service.infrastructure.persistence;

import com.wanderpass.card_service.domain.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
    boolean existsByCardNumber(String cardNumber);
}
