package com.cardgame.cardgame.actor.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Actor {
    @Id
    @GeneratedValue
    private Integer id;
    private String surName;
    private String lastName;

    private String birthday;

    public Actor() {
    }

    public Actor(String surName, String lastName, String birthday) {
        this.surName = surName;
        this.lastName = lastName;
        this.birthday = birthday;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
