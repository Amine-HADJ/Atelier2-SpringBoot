package com.cardgame.cardgame.services;

import com.cardgame.cardgame.models.User;
import com.cardgame.cardgame.repositories.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User registerUser(User user) {
        return userRepo.save(user);
    }
}
