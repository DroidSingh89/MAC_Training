package com.example.user.recyclerview;

/**
 * Created by singh on 10/4/17.
 */

public class Animal {

    String type;
    String name;
    int weight;
    String imageUrl;

    public Animal(String type, String name, int weight, String imageUrl) {
        this.type = type;
        this.name = name;
        this.weight = weight;
        this.imageUrl = imageUrl;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
