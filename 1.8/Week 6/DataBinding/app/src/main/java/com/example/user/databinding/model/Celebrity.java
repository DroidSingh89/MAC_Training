package com.example.user.databinding.model;

import android.databinding.ObservableField;
import android.text.Editable;
import android.text.TextWatcher;

/**
 * Created by singh on 2/14/18.
 */

public class Celebrity {


    String firstName;
    String lastName;
    String gender;
    String industry;

    ObservableField<String> firstNameObs = new ObservableField<>();
    ObservableField<String> lastNameObs = new ObservableField<>();
    ObservableField<String> genderObs = new ObservableField<>();
    ObservableField<String> industryObs = new ObservableField<>();


    public Celebrity(String firstName, String lastName, String gender, String industry) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.industry = industry;
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

    public ObservableField<String> getGenderObs() {
        return genderObs;
    }

    public void setGenderObs(ObservableField<String> genderObs) {
        this.genderObs = genderObs;
    }

    public ObservableField<String> getIndustryObs() {
        return industryObs;
    }

    public void setIndustryObs(ObservableField<String> industryObs) {
        this.industryObs = industryObs;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    @Override
    public String toString() {
        return "Celebrity{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", industry='" + industry + '\'' +
                '}';
    }
}

