package com.cardgame.cardgame.services;

import com.cardgame.cardgame.models.Card;
import com.cardgame.cardgame.models.DataFormatter;
import com.cardgame.cardgame.models.Inventory;
import com.cardgame.cardgame.models.AppUser;
import com.cardgame.cardgame.repositories.InventoryRepo;
import com.cardgame.cardgame.repositories.UserRepo;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService{

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

        return byEmail || byUsername;
    }

    public Integer registerUser(AppUser user) {
        AppUser newUser = new AppUser(user.getUsername(), user.getEmail(), user.getPassword());
        List<Card> cards = cardService.generateCards();
        Inventory inventory = new Inventory(cards);
        newUser.setInventory(inventory);
        inventoryRepo.save(inventory);
        AppUser savedUser = userRepo.save(newUser);

        return savedUser.getId();
    }

    public Map<String, Object> getUsersDetails(String userId) {
        Integer userIdInt = Integer.parseInt(userId);
        java.util.Optional<AppUser> userOptional = userRepo.findById(userIdInt);
        System.out.println(userId);
        if (userOptional.isPresent()) {
            AppUser user = userOptional.get();
            String username = user.getUsername();
            Double userMoney = user.getWallet();
            return DataFormatter.formatUsersDetails(username, userMoney);
        }
        return null;
    }

    /* 
    public Inventory getInventory(Integer userId) {
        Inventory inventory = inventoryRepo.findById(userId.get);
        return inventory;
    }
    */
}
