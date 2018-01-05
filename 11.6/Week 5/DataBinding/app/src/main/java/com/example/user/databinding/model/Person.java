package com.example.user.databinding.model;

import android.databinding.ObservableField;
import android.text.Editable;
import android.text.TextWatcher;

/**
 * Created by singh on 12/5/17.
 */

public class Person {

    String name;
    String age;

    ObservableField<String> nameObs = new ObservableField<>();
    ObservableField<String> ageObs = new ObservableField<>();

    public ObservableField<String> getNameObs() {
        return nameObs;
    }

    public void setNameObs(ObservableField<String> nameObs) {
        this.nameObs = nameObs;
    }

    public ObservableField<String> getAgeObs() {
        return ageObs;
    }

    public void setAgeObs(ObservableField<String> ageObs) {
        this.ageObs = ageObs;
    }

    public TextWatcher watcherName = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {

            nameObs.set(s.toString());

        }
    };

    public TextWatcher watcherAge = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {

            ageObs.set(s.toString());
        }
    };


    public Person(String name, String age) {
        this.name = name;
        this.age = age;
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
}

