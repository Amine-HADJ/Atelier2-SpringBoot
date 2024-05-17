package com.cardgame.cardgame.services;

import org.springframework.stereotype.Service;

import com.cardgame.cardgame.models.Card;
import com.cardgame.cardgame.models.Inventory;
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

    public void buyCard(Integer userId, int cardId) {

        // //Check if the card is available
        // if (cardRepo.findById(card.getId()).isEmpty()){
        //     System.out.println("Card not available");
        //     return;
        // }
        
        // //Check if the user has enough money
        // if (userRepo.findById(userId).get().getWallet() < card.getPrice()){
        //     System.out.println("Not enough money");
        //     return;
        // }

        // //Add card to user inventory
        // inventoryRepo.findById(userId).get().addCard(card);

        // //Update user wallet
        // userRepo.findById(userId).get().setWallet( -card.getPrice() );

        // //Remove card from cardRepo
        // cardRepo.deleteById(card.getId());

        }

    public void sellCard(Integer userId, int cardId) {
            Inventory userInventoy = inventoryRepo.findById(userId).get();
            List<Card> useCards = userInventoy.getCards();
            
            // Check if the user has the card
            if (!useCards.contains(cardRepo.findById(cardId).get())) {
                System.out.println("User does not have the card");
                return;
            }
            System.out.println("User has the card");
            userRepo.findById(userId).get().setWallet(cardRepo.findById(cardId).get().getPrice());

            // on save le wallet dans la database 
            userRepo.save(userRepo.findById(userId).get());


            System.out.println(cardRepo.findById(cardId).get().getPrice());

           
            
            
        }

    public List<Card> getCards() {
        return cardRepo.findAll();
    }

}