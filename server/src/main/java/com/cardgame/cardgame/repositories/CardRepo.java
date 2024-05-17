package com.cardgame.cardgame.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cardgame.cardgame.models.Card;


@Repository
public interface CardRepo extends CrudRepository<Card, Integer> {
    List<Card> findByFamilyName(String familyName);
    @SuppressWarnings("null")
    List<Card> findAll();
}



