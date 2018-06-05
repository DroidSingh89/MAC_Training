package com.example.user.activitylifecycleandintent.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class PersonP implements Parcelable{

    String name;
    String age;

    public PersonP(String name, String age) {
        this.name = name;
        this.age = age;
    }

    protected PersonP(Parcel in) {
        name = in.readString();
        age = in.readString();
    }

    public static final Creator<PersonP> CREATOR = new Creator<PersonP>() {
        @Override
        public PersonP createFromParcel(Parcel in) {
            return new PersonP(in);
        }

        @Override
        public PersonP[] newArray(int size) {
            return new PersonP[size];
        }
    };

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(age);
    }
}
