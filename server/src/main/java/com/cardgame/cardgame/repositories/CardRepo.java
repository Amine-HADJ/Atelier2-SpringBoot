package com.cardgame.cardgame.repositories;
import com.cardgame.cardgame.models.Card;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CardRepo extends CrudRepository<Card, Integer> {
    List<Card> findByFamilyName(String familyName);
    List<Card> findAll();
}



