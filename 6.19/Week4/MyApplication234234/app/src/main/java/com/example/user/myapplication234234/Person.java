package com.example.user.myapplication234234;

/**
 * Created by singh on 8/24/17.
 */

public class Person {

    String name;
    int age;
    String gender;
    String imageUrl;

    public Person(String name, int age, String gender, String imageUrl) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
