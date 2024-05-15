package com.cardgame.cardgame.services;

import com.cardgame.cardgame.models.Card;
import com.cardgame.cardgame.models.Inventory;
import com.cardgame.cardgame.models.User;
import com.cardgame.cardgame.repositories.InventoryRepo;
import com.cardgame.cardgame.repositories.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepo userRepo;
    private final CardService cardService;
    private final InventoryRepo inventoryRepo;

    public UserService(UserRepo userRepo, CardService cardService, InventoryRepo inventoryRepo) {
        this.userRepo = userRepo;
        this.cardService = cardService;
        this.inventoryRepo = inventoryRepo;
    }

    public User registerUser(User user) {
        User savedUser = userRepo.save(user);
        List<Card> cards = cardService.generateCards();
        Inventory inventory = new Inventory(savedUser.getId(), cards);
        inventoryRepo.save(inventory);

        return savedUser;
    }
}
