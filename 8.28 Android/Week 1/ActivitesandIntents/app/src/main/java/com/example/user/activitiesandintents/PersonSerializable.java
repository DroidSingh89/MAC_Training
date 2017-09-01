package com.example.user.activitiesandintents;

import java.io.Serializable;

/**
 * Created by singh on 8/31/17.
 */

public class PersonSerializable implements Serializable{

    String name;
    String gender;

    public PersonSerializable(String name, String gender) {
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

    @Override
    public String toString() {
        return "PersonSerializable{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
