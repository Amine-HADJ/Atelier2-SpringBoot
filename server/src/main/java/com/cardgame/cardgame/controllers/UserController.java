package com.cardgame.cardgame.controllers;

import com.cardgame.cardgame.models.User;
import com.cardgame.cardgame.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService uService;

    public UserController(UserService uService) {
        this.uService = uService;
    }

    @PostMapping("/buycard")
    public void Achat_Carte() {
        return;
    }

    @PostMapping("/sellcard")
    public void Vente_carte() {
        return;
    }
}
