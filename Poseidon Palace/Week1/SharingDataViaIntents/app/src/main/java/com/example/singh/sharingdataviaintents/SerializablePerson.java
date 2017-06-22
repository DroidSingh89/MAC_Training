package com.example.singh.sharingdataviaintents;

import java.io.Serializable;

/**
 * Created by singh on 6/22/17.
 */

public class SerializablePerson implements Serializable {


    String name;
    int age;
    String gender;


    public SerializablePerson(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
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
