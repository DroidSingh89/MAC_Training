
package com.example.user.makingrestcalls.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Dob {

    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("age")
    @Expose
    private Integer age;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
