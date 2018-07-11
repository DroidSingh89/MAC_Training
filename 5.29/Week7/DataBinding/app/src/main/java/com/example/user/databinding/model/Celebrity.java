package com.example.user.databinding.model;

import android.databinding.ObservableField;
import android.text.Editable;
import android.text.TextWatcher;

public class Celebrity {

    String name;
    String profession;
    String gender;

    //    two way databinding field
    private ObservableField<String> nameObs;


    public Celebrity(String name, String profession, String gender) {
        this.name = name;
        this.profession = profession;
        this.gender = gender;
        nameObs = new ObservableField<>();
    }

    public ObservableField<String> getNameObs() {
        return nameObs;
    }

    public void setNameObs(ObservableField<String> nameObs) {
        this.nameObs = nameObs;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
