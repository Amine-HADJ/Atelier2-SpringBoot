package com.cardgame.cardgame.services;

import org.springframework.stereotype.Service;

import com.cardgame.cardgame.models.Card;

import com.cardgame.cardgame.repositories.CardRepo;
import com.cardgame.cardgame.repositories.InventoryRepo;
import com.cardgame.cardgame.repositories.UserRepo;

import java.util.List;


@Service
public class MarketService {

    private CardRepo cardRepo;
    private InventoryRepo inventoryRepo;
    private UserRepo userRepo;

    public MarketService(CardRepo cardRepo, InventoryRepo inventoryRepo, UserRepo userRepo) {
        this.cardRepo = cardRepo;   
        this.inventoryRepo = inventoryRepo;   
        this.userRepo = userRepo;
    }

    public void buyCard(Integer userId, Card card) {

        //Check if the card is available
        if (cardRepo.findById(card.getId()).isEmpty()){
            System.out.println("Card not available");
            return;
        }
        
        //Check if the user has enough money
        if (userRepo.findById(userId).get().getWallet() < card.getPrice()){
            System.out.println("Not enough money");
            return;
        }

        //Add card to user inventory
        inventoryRepo.findById(userId).get().addCard(card);

        //Update user wallet
        userRepo.findById(userId).get().setWallet( -card.getPrice() );

        //Remove card from cardRepo
        cardRepo.deleteById(card.getId());

        }

    public void sellCard(Integer userId, Card card) {

            //Check if the card is in the user inventory
            if (!inventoryRepo.findById(userId).get().getCards().contains(card)){
                System.out.println("Card not in inventory");
                return;
            }

            //Add card to cardRepo
            cardRepo.save(card);

            //Update user wallet
            userRepo.findById(userId).get().setWallet(card.getPrice());

            //Remove card from user inventory
            inventoryRepo.findById(userId).get().getCards().remove(card);

        }

    public List<Card> getCards() {
        return cardRepo.findAll();
    }

}