package com.cardgame.cardgame.movie.controller;

import com.cardgame.cardgame.movie.model.Movie;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MovieDao {
    private Map<Integer, Movie> mMap=new HashMap<>();;

    public MovieDao() {
        for(int i=0; i<10;i++){
            Movie m = new Movie(i,"SF","myTitle"+i,"description"+i,100000*i);
            mMap.put(i,m);
        }
    }

    public Map<Integer,Movie> getmMap(){
        return this.mMap;
    }

    public Movie getMap(Integer id){
        return this.mMap.get(id);
    }
}
