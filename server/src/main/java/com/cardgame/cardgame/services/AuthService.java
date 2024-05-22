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

    public Integer checkLogin(String identifier, String password){
        AppUser userByEmail = uRepo.findByEmail(identifier);
        AppUser userByUsername = uRepo.findByUsername(identifier);
        AppUser user = userByEmail == null ? userByUsername : userByEmail;
        if(password.equals(user.getPassword())){
            return user.getId();
        }
        return -1;
    }
}

