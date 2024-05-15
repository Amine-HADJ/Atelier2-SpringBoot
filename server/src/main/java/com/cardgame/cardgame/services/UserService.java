package com.cardgame.cardgame.services;

import com.cardgame.cardgame.models.Card;
import com.cardgame.cardgame.models.DataFormatter;
import com.cardgame.cardgame.models.Inventory;
import com.cardgame.cardgame.models.User;
import com.cardgame.cardgame.repositories.InventoryRepo;
import com.cardgame.cardgame.repositories.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

    public boolean checkIfUserExists(String username, String email){
        boolean byEmail = userRepo.findByEmail(email) != null;
        boolean byUsername = userRepo.findByUsername(username) != null;

        return byEmail && byUsername;
    }

    public User registerUser(User user) {
        User savedUser = userRepo.save(user);
        List<Card> cards = cardService.generateCards();
        Inventory inventory = new Inventory(savedUser.getId(), cards);
        inventoryRepo.save(inventory);

        return savedUser;
    }

    public Map<String, Object> getUsersDetails(Integer userId) {
        String username = userRepo.findById(userId).get().getUsername();
        Double userMoney = userRepo.findById(userId).get().getWallet();
        Map<String, Object> userDetails = DataFormatter.formatUsersDetails(username, userMoney);

        return userDetails;
    }

    public Inventory getInventory(Integer userId) {
        Inventory inventory = inventoryRepo.findByUserId(userId);
        return inventory;
    }
}
