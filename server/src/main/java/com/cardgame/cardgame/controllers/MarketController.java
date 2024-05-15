package com.cardgame.cardgame.controllers;

import com.cardgame.cardgame.models.User;
import com.cardgame.cardgame.services.MarketService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarketController {

    private final MarketService mService;

    public MarketController(MarketService mService) {
        this.mService = mService;
    }

    @PostMapping("/signup")
    public void inscription() {
        return;
    }
}