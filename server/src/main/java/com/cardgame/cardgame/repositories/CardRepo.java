package com.cardgame.cardgame.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cardgame.cardgame.models.Card;



public interface CardRepo extends CrudRepository<Card, Integer> {
    List<Card> findByFamilyName(String familyName);
    List<Card> findAll();
}



