package com.cardgame.cardgame.controllers;

import com.cardgame.cardgame.models.Inventory;
import com.cardgame.cardgame.models.AppUser;
import com.cardgame.cardgame.services.UserService;

import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    
    private final UserService uService;

    
    public UserController(UserService uService) {
        this.uService = uService;
    }

    @PostMapping("/register")
    @CrossOrigin(origins = "*")
    public ResponseEntity<String> register(@RequestBody AppUser user) {
        boolean exists = uService.checkIfUserExists(user.getUsername(), user.getEmail());
        if (!exists) {
            Integer userId = uService.registerUser(user);
            String userIdStr = userId.toString();
            return ResponseEntity.ok(userIdStr);
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("User with the provided username or email already exists");
        }
    }

    @PostMapping("/getuserdetails")
    @CrossOrigin(origins = "*")
    public Map<String, Object> details(@RequestBody String userId) {
        return uService.getUsersDetails(userId);
    }

    @PostMapping("/getinventory")
    @CrossOrigin(origins = "*")
    public Optional<Inventory> inventory(@RequestBody String userId) {
        return uService.getInventory(userId);
    }
}
