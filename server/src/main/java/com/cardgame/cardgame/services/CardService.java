package com.cardgame.cardgame.services;

import com.cardgame.cardgame.repositories.CardRepo;
import com.cardgame.cardgame.models.Card;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardService {

    private final CardRepo cardRepo;
    private final ImgGeneratorService imgGeneratorService;
    private final PromptGeneratorService promptGeneratorService;


    public CardService(CardRepo cardRepo, ImgGeneratorService imgGeneratorService, PromptGeneratorService promptGeneratorService) {
        this.cardRepo = cardRepo;
        this.imgGeneratorService = imgGeneratorService;
        this.promptGeneratorService = promptGeneratorService;
    }

    public String createCard(String prompt) {
        String promptResponse = promptGeneratorService.requestPromptGeneration(prompt);
        // Process the prompt response if needed
        String imageRequestId = imgGeneratorService.requestImageGeneration(prompt);
        // Process the image request response if needed
        return imageRequestId;
    }

    public List<Card> generateCards() {
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int length = (int) cardRepo.count();
            cards.add(cardRepo.findById((int) (Math.random() * length) + 1).get());
        }
        return cards;
    }

    public void addAllCards(List<Card> cards) {
        for(Card card : cards){
            cardRepo.save(card);
        }
    }
}


    