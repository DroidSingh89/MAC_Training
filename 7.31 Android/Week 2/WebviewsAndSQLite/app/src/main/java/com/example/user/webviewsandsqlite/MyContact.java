package com.example.user.webviewsandsqlite;

/**
 * Created by singh on 8/7/17.
 */

public class MyContact

{


    String name;
    String number;

    public MyContact(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
