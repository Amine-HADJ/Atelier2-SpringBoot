package com.cardgame.cardgame.models.requests;

public class MarketRequest {
    private String userId;
    private int cardId;

    public MarketRequest(String userId, int cardId) {
        this.userId = userId;
        this.cardId = cardId;
    }

    public Integer getUserId() {
        Integer userId = Integer.parseInt(this.userId);
        return userId;
    }

    public int getCardId() {
        return cardId;
    }

    
}


