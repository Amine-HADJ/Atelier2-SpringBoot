package com.cardgame.cardgame.controllers;

import com.cardgame.cardgame.models.User;
import com.cardgame.cardgame.services.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final AuthService aService;

    public AuthController(AuthService aService) {
        this.aService = aService;
    }

    @PostMapping("/login")
    public void connexion() {
        return;
    }
}