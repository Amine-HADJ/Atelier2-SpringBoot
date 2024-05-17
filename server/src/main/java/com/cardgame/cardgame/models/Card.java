package com.cardgame.cardgame.models;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Card implements java.io.Serializable{
    @Id
    private Integer id;
   
    
    private String familyName;
    
    @jakarta.persistence.Column(length = 1000)
    private String imgSrc;
    
    private String name;

    @jakarta.persistence.Column(length = 1000)
    private String description;
    
    private int hp;
    
    private int energy;
    
    private int attack;
    
    private int defense;
    
    private double price;

    // Default constructor is required for JPA
    public Card() {}

    public Card(String familyName, String imgSrc, String name, String description, int hp, int energy, int attack, int defense, int price) {
        this.familyName = familyName;
        this.imgSrc = imgSrc;
        this.name = name;
        this.description = description;
        this.hp = hp;
        this.energy = energy;
        this.attack = attack;
        this.defense = defense;
        this.price = price;
        
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

  
}