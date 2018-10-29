package com.example.user.handlingactivitylifecycle.model;


import android.os.Parcel;
import android.os.Parcelable;

public class PersonParcel implements Parcelable {

    String name;
    String age;
    String gender;

    public PersonParcel(String name, String age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    protected PersonParcel(Parcel in) {
        name = in.readString();
        age = in.readString();
        gender = in.readString();
    }

    public static final Creator<PersonParcel> CREATOR = new Creator<PersonParcel>() {
        @Override
        public PersonParcel createFromParcel(Parcel in) {
            return new PersonParcel(in);
        }

        @Override
        public PersonParcel[] newArray(int size) {
            return new PersonParcel[size];
        }
    };

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(age);
        dest.writeString(gender);
    }
}
