package com.example.user.services.model;

/**
 * Created by singh on 10/9/17.
 */

public class Car {

    String type;
    String make;
    String model;
    int year;
    String color;

    public Car(String type, String make, String model, int year, String color) {
        this.type = type;
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
