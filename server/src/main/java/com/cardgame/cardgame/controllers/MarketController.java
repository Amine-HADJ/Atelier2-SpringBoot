package com.cardgame.cardgame.controllers;

import com.cardgame.cardgame.models.User;
import com.cardgame.cardgame.models.Card;
import com.cardgame.cardgame.services.MarketService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class MarketController {

    private final MarketService mService;

    public MarketController(MarketService mService) {
        this.mService = mService;
    }

    @PostMapping("/buycard")
    public void buyCard(@RequestParam Integer userId, @RequestParam Card card) {
        mService.buyCard(userId, card);
    }


    @PostMapping("/sellcard")
    public void sellCard(@RequestParam Integer userId, @RequestParam Card card) {
        mService.sellCard(userId, card);
    }

    @GetMapping("/getcards")
    public List<Card> getCards() {
        return mService.getCards();
    }

    @GetMapping("/getusers")
    public List<User> getUsers() {
        return mService.getUsersDetails();
    }


    
}