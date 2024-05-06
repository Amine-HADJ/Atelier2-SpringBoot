package com.cardgame.cardgame.actor.controller;

import com.cardgame.cardgame.actor.model.Actor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ActorService {

    private final ActorRepo aRepo;

    public ActorService(ActorRepo aRepo) {
        this.aRepo = aRepo;
//        for(int i=0; i<10;i++){
//            Actor a = new Actor("actorName"+i,"actorLastName"+i,"date "+i);
//            aRepo.save(a);
//        }
    }

    public List<Actor> getAllActors(){
        List<Actor> localAList=new ArrayList<>();
        Iterable<Actor> it = aRepo.findAll();
        for(Actor a : it){
            localAList.add(a);
        }
            return localAList;
    }

    public Actor addActor(Actor a) {
        return aRepo.save(a);
    }
}
