package com.cardgame.cardgame.repositories;

import com.cardgame.cardgame.models.User;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User,Integer> {
    List<User> findAll();
}