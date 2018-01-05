package com.example.user.listcontainers.model;

/**
 * Created by singh on 12/6/17.
 */

public class Animal {

    String type;
    String weight;
    String category;


    public Animal(String type, String weight, String category) {
        this.type = type;
        this.weight = weight;
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "type='" + type + '\'' +
                ", weight='" + weight + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
