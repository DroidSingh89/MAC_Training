package com.example.user.databinding;

import android.databinding.ObservableField;
import android.text.Editable;
import android.text.TextWatcher;

public class Person {

    String name;
    String gender;
    String age;

    public ObservableField<String> nameObs = new ObservableField<>();

    public TextWatcher nameWatcher = new TextWatcher() {
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


    public Person(String name, String gender, String age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age='" + age + '\'' +
                '}';
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
