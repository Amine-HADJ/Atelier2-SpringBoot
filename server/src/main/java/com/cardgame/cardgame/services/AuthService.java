package com.cardgame.cardgame.services;

import com.cardgame.cardgame.models.User;
import com.cardgame.cardgame.repositories.UserRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthService {

    private final UserRepo uRepo;

    public AuthService(UserRepo uRepo) {
        this.uRepo = uRepo;   
    }

    public List<User> getAllUsers(){
        List<User> localAList=new ArrayList<>();
        Iterable<User> it = uRepo.findAll();
        for(User a : it){
            localAList.add(a);
        }
            return localAList;
    }
}

