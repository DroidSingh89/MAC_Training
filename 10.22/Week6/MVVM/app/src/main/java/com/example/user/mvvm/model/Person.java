package com.example.user.mvvm.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.databinding.ObservableField;
import android.databinding.adapters.TextViewBindingAdapter;

@Entity
public class Person {

    private static final String TAG = Person.class.getSimpleName()+ "_TAG";
    String name;
    String age;

    //observable fields
    @Ignore
    public ObservableField<String> nameObs = new ObservableField<>();
    @Ignore
    public ObservableField<String> ageObs = new ObservableField<>();



    @Ignore
    public TextViewBindingAdapter.OnTextChanged onNameChanged = new TextViewBindingAdapter.OnTextChanged() {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            nameObs.set(String.valueOf(s));
        }
    };

    @Ignore
    public TextViewBindingAdapter.OnTextChanged onAgeChanged = new TextViewBindingAdapter.OnTextChanged() {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            ageObs.set(String.valueOf(s));
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

    public String toStringObs() {
        return "Person{" +
                "nameObs=" + nameObs.get() +
                ", ageObs=" + ageObs.get() +
                '}';
    }

    @Override
    public String toString() {
        return "Person{" +
                "name=" + name +
                ", age=" + age +
                '}';
    }



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
}
