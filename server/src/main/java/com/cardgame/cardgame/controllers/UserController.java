package com.cardgame.cardgame.controllers;

import com.cardgame.cardgame.models.Inventory;
import com.cardgame.cardgame.models.AppUser;
import com.cardgame.cardgame.services.UserService;

import java.util.Map;

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
            uService.registerUser(user);
            return ResponseEntity.ok("User registered successfully");
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("User with the provided username or email already exists");
        }
    }

    @PostMapping("/getuserdetails")
    @CrossOrigin(origins = "*")
    public Map<String, Object> details(@RequestBody Integer userId) {
        return uService.getUsersDetails(userId);
    }

    @PostMapping("/getinventory")
    @CrossOrigin(origins = "*")
    public Inventory inventory(@RequestBody Integer userId) {
        return uService.getInventory(userId);
    }
}
