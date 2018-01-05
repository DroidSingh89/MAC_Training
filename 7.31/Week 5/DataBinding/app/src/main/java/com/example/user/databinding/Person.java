package com.example.user.databinding;

import android.databinding.ObservableField;
import android.text.Editable;
import android.text.TextWatcher;

import org.w3c.dom.Text;

/**
 * Created by singh on 8/30/17.
 */

public class Person {

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    private ObservableField<String> firstNameObs = new ObservableField<>();
    private ObservableField<String> lastNameObs = new ObservableField<>();


    public void setFirstNameObs(ObservableField<String> firstNameObs) {
        this.firstNameObs = firstNameObs;
    }

    public void setLastNameObs(ObservableField<String> lastNameObs) {
        this.lastNameObs = lastNameObs;
    }

    public ObservableField<String> getFirstNameObs() {
        return firstNameObs;
    }

    public ObservableField<String> getLastNameObs() {
        return lastNameObs;
    }

    public TextWatcher watcherFirstName = new TextWatcher() {
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


    public TextWatcher watcherLastName = new TextWatcher() {
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

    String firstName;
    String lastName;

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
