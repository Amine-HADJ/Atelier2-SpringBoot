package com.cardgame.cardgame.services;

import com.cardgame.cardgame.models.AppUser;
import com.cardgame.cardgame.repositories.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepo uRepo;

    public AuthService(UserRepo uRepo) {
        this.uRepo = uRepo;   
    }

    public boolean checkLogin(String identifier, String password){
        AppUser userByEmail = uRepo.findByEmail(identifier);
        AppUser userByUsername = uRepo.findByUsername(identifier);
        AppUser user = userByEmail == null ? userByUsername : userByEmail;
        if(user.getPassword() == password){
            return true;
        }
        return false;
    }
}

