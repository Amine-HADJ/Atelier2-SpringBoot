package com.cardgame.cardgame.repositories;

import com.cardgame.cardgame.models.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepo extends CrudRepository<User,Integer> {
    User findByEmail(String email);
    User findByUsername(String username);
}