package com.cardgame.cardgame.models.requests;
import com.cardgame.cardgame.models.Card;

public class MarketRequest {
    private String userId;
    private Card card;

    public MarketRequest(String userId, Card card) {
        this.userId = userId;
        this.card = card;
    }

    public Integer getUserId() {
        Integer userId = Integer.parseInt(this.userId);
        return userId;
    }

    public Card getCard() {
        return card;
    }
}


