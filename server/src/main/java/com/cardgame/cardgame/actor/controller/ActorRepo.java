package com.cardgame.cardgame.actor.controller;

import com.cardgame.cardgame.actor.model.Actor;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepo extends CrudRepository<Actor, Integer> {
    List<Actor> findAll();

}
