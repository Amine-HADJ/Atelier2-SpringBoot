package com.cardgame.cardgame.movie.model;

public class Movie {

    private Integer id;
    private String type;
    private String title;
    private String description;
    private float budget;

    public Movie(Integer i,String type, String title, String description, float budget) {
        this.id=i;
        this.type = type;
        this.title = title;
        this.description = description;
        this.budget = budget;
    }

    public Movie() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getBudget() {
        return budget;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
