package com.example.user.layoutandviews;

import java.io.Serializable;

/**
 * Created by singh on 8/2/17.
 */

public class Person implements Serializable{


    String name;
    String gender;

    public Person(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
