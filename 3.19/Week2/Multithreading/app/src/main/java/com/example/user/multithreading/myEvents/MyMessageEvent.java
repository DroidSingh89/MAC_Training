package com.example.user.multithreading.myEvents;

public class MyMessageEvent {

    String data;

    public MyMessageEvent(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
