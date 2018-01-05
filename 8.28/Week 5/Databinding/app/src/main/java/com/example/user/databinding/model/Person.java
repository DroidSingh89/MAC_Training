package com.example.user.databinding.model;

import android.databinding.ObservableField;
import android.text.Editable;
import android.text.TextWatcher;

/**
 * Created by singh on 9/28/17.
 */

public class Person {

    String name;
    String age;
    String email;

    ObservableField<String> nameObs = new ObservableField<>();
    ObservableField<String> ageObs = new ObservableField<>();
    ObservableField<String> emailObs = new ObservableField<>();

    public ObservableField<String> getNameObs() {
        return nameObs;
    }

    public ObservableField<String> getAgeObs() {
        return ageObs;
    }

    public ObservableField<String> getEmailObs() {
        return emailObs;
    }

    public TextWatcher watcherName = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {

            nameObs.set(editable.toString());
        }
    };

    public TextWatcher watcherAge = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


        }

        @Override
        public void afterTextChanged(Editable editable) {

            ageObs.set(editable.toString());
        }
    };

    public TextWatcher watcherEmail = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            emailObs.set(editable.toString());
        }
    };



    public Person(String name, String age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
