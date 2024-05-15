package com.cardgame.cardgame.controllers;

import com.cardgame.cardgame.models.User;
import com.cardgame.cardgame.services.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService uService;

    public UserController(UserService uService) {
        this.uService = uService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestParam String username, @RequestParam String email, @RequestParam String password) {
        boolean exists = uService.checkIfUserExists(username, email);
        if (!exists) {
            User user = new User(username, email, password);
            uService.registerUser(user);
            return ResponseEntity.ok("success");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
