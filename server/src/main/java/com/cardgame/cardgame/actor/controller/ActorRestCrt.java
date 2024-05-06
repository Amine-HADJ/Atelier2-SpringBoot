package com.cardgame.cardgame.actor.controller;

import com.cardgame.cardgame.actor.model.Actor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ActorRestCrt {

    private final ActorService aService;

    public ActorRestCrt(ActorService aService) {
        this.aService = aService;
    }

    @GetMapping("/actors")
    public List<Actor> getAllActor(){
        return aService.getAllActors();
    }

    @PostMapping("/actor")
    public Actor addActor(@RequestBody Actor a){
        return aService.addActor(a);
    }


}
