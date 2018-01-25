package com.example.user.multithreading;

/**
 * Created by singh on 1/25/18.
 */

public class MyEvent {

    String data;

    public MyEvent(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
