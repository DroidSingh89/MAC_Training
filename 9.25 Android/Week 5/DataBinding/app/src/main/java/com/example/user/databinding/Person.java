package com.example.user.databinding;

import android.databinding.ObservableField;
import android.text.Editable;
import android.text.TextWatcher;

/**
 * Created by singh on 10/24/17.
 */

public class Person {


    String firstName;
    String lastName;


    ObservableField<String> firstNameObs = new ObservableField<>();
    ObservableField<String> lastNameObs = new ObservableField<>();


    public TextWatcher watcherFName = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {

            firstNameObs.set(editable.toString());
        }
    };

    public TextWatcher watcherLName = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {

            lastNameObs.set(editable.toString());
        }
    };



    public ObservableField<String> getFirstNameObs() {
        return firstNameObs;
    }

    public void setFirstNameObs(ObservableField<String> firstNameObs) {
        this.firstNameObs = firstNameObs;
    }

    public ObservableField<String> getLastNameObs() {
        return lastNameObs;
    }

    public void setLastNameObs(ObservableField<String> lastNameObs) {
        this.lastNameObs = lastNameObs;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

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
