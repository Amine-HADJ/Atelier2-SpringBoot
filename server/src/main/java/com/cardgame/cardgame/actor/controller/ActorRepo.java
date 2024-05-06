package com.cardgame.cardgame.actor.controller;

import com.cardgame.cardgame.actor.model.Actor;
import org.springframework.data.repository.CrudRepository;

public interface ActorRepo extends CrudRepository<Actor,Integer> {
}
