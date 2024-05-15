package com.cardgame.cardgame.services;

import com.cardgame.cardgame.repositories.CardRepo;
import com.cardgame.cardgame.models.Card;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardService {

    private CardRepo CardRepo;



   // Card service generate 5 randoms cards from CardRepository
    public List<Card> generateCards() {
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            //getting length of CardRepo
            int length = (int) CardRepo.count();
            cards.add(CardRepo.findById((int) (Math.random() * length) + 1).get());
        }
        return cards;
    }
}


    