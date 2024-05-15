package com.cardgame.cardgame.services;

import com.cardgame.cardgame.models.User;
import com.cardgame.cardgame.repositories.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepo uRepo;

    public AuthService(UserRepo uRepo) {
        this.uRepo = uRepo;   
    }

    public boolean checkLogin(String identifier, String password){
        User userByEmail = uRepo.findByEmail(identifier);
        User userByUsername = uRepo.findByUsername(identifier);
        User user = userByEmail == null ? userByUsername : userByEmail;
        if(user.getPassword() == password){
            return true;
        }
        return false;
    }
}

