package com.cardgame.cardgame.controllers;

import com.cardgame.cardgame.models.Card;
import com.cardgame.cardgame.models.requests.MarketRequest;
import com.cardgame.cardgame.services.CardService;
import com.cardgame.cardgame.services.MarketService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MarketController {

    private final MarketService mService;
    private final CardService cService;

    public MarketController(MarketService mService, CardService cService) {
        this.mService = mService;
        this.cService = cService;
    }

    @PostMapping("/buycard")
    @CrossOrigin(origins = "*")
    public void buyCard(@RequestBody MarketRequest req) {
        mService.buyCard(req.getUserId(), req.getCardId());
    }


    @PostMapping("/sellcard")
    @CrossOrigin(origins = "*")
    public void sellCard(@RequestBody MarketRequest req) {
        mService.sellCard(req.getUserId(), req.getCardId());
    }
    
    @GetMapping("/getmarket")
    @CrossOrigin(origins = "*")
    public List<Card> market() {
        return mService.getCards();
    }

    @PostMapping("/generateCards")
    @CrossOrigin(origins = "*")
    public ResponseEntity<String> generateCards(@RequestBody List<Card> cards) {
        cService.generateAllCards(cards);
        return ResponseEntity.ok("Cards added");
    }
}