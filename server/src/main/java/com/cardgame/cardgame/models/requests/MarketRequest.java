package com.cardgame.cardgame.models.requests;
import com.cardgame.cardgame.models.Card;

import jakarta.persistence.Entity;

@Entity
public class MarketRequest {
    private Integer userId;
    private Card card;

    public MarketRequest(Integer userId, Card card) {
        this.userId = userId;
        this.card = card;
    }

    public Integer getUserId() {
        return userId;
    }

    public Card getCard() {
        return card;
    }
}


