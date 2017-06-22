package com.example.singh.sharingdataviaintents;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by singh on 6/22/17.
 */

public class ParcelablePerson implements Parcelable{


    String name ;
    int age;
    String gender;


    public ParcelablePerson(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }


    protected ParcelablePerson(Parcel in) {
        name = in.readString();
        age = in.readInt();
        gender = in.readString();
    }

    public static final Creator<ParcelablePerson> CREATOR = new Creator<ParcelablePerson>() {
        @Override
        public ParcelablePerson createFromParcel(Parcel in) {
            return new ParcelablePerson(in);
        }

        @Override
        public ParcelablePerson[] newArray(int size) {
            return new ParcelablePerson[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(age);
        dest.writeString(gender);
    }
}
