package com.example.user.parcelableandserializable;

import java.io.Serializable;

/**
 * Created by singh on 9/28/17.
 */

public class PersonSerializable implements Serializable{

    String name;
    String age;
    String gender;
    String address;

    public PersonSerializable(String name, String age, String gender, String address) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
