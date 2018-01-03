package com.example.user.mvvm_databinding.model;

import android.databinding.ObservableField;
import android.text.Editable;
import android.text.TextWatcher;

/**
 * Created by singh on 1/3/18.
 */

public class Person {

    public String firstName;
    public String lastName;


    public ObservableField<String> firstNameObs = new ObservableField<>();
    public ObservableField<String> lastNameObs = new ObservableField<>();


    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public TextWatcher watcherFirstName = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {

            firstNameObs.set(s.toString());
        }
    };

    public TextWatcher watcherLastName = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {


        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {

            lastNameObs.set(s.toString());
        }
    };



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

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
