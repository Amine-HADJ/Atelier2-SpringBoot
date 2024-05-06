package com.cardgame.cardgame.movie.controller;

import com.cardgame.cardgame.movie.model.Movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MovieRestCrt {


    private final MovieDao mDoa;

    public MovieRestCrt(MovieDao mDoa) {
        this.mDoa = mDoa;
    }

    @GetMapping("/movies")
    public Map<Integer,Movie> getAllMovies(){
        return mDoa.getmMap();
    }

    @GetMapping("/movie/{myid}")
    public Movie getMovie(@PathVariable Integer myid){
        return mDoa.getMap(myid);
    }


}
