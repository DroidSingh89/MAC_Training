package com.example.singh.mvp_dagger.model;

import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by singh on 7/12/17.
 */

public class Person implements Serializable{


    String firstName;
    String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
