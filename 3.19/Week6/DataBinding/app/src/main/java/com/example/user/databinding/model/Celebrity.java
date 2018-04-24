package com.example.user.databinding.model;

import android.databinding.ObservableField;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;

import static android.content.ContentValues.TAG;

public class Celebrity {

    String firstName;
    String lastName;
    String industry;

    public ObservableField<String> firstNameObs = new ObservableField<>();
    public ObservableField<String> lastNameObs = new ObservableField<>();
    public ObservableField<String> industryObs = new ObservableField<>();

    public Celebrity(String firstName, String lastName, String industry) {
        firstNameObs.set(firstName);
        lastNameObs.set(lastName);
        industryObs.set(industry);
    }

    public TextWatcher firstNameWatcher = new TextWatcher() {
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

    public TextWatcher lastNameWatcher = new TextWatcher() {
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

    TextWatcher industryWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            industryObs.set(editable.toString());

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

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }
}
