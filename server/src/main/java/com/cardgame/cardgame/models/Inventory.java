package com.cardgame.cardgame.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;



@Entity
public class Inventory {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer userId;
    private List<Card> cards;
    

    public Inventory(Integer userId, List<Card> cards) {
        this.userId = userId;
        this.cards = cards;
    }

    public Integer getId() {
        return id;
    }

    public Integer getUserId() {
        return userId;
    }

    public List<Card> getCards() {
        return cards;
    }

    
  

}
