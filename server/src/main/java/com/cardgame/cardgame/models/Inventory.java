package com.cardgame.cardgame.models;

import org.hibernate.mapping.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.util.ArrayList;



@Entity
public class Inventory {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer userId;
    private ArrayList<Card> cards;
    

    public Inventory(Integer userId, ArrayList<Card> cards) {
        this.userId = userId;
        this.cards = cards;
    }

    public Integer getId() {
        return id;
    }

    public Integer getUserId() {
        return userId;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    
  

}
