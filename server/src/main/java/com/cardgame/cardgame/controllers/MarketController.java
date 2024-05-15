package com.cardgame.cardgame.controllers;

import com.cardgame.cardgame.models.Card;
import com.cardgame.cardgame.models.requests.MarketRequest;
import com.cardgame.cardgame.services.MarketService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MarketController {

    private final MarketService mService;

    public MarketController(MarketService mService) {
        this.mService = mService;
    }

    @PostMapping("/buycard")
    public void buyCard(@RequestBody MarketRequest req) {
        mService.buyCard(req.getUserId(), req.getCard());
    }


    @PostMapping("/sellcard")
    public void sellCard(@RequestBody MarketRequest req) {
        mService.sellCard(req.getUserId(), req.getCard());
    }
    
    @GetMapping("/getmarket")
    public List<Card> market() {
        return mService.getCards();
    }
}