package com.example.user.multithreading.model.event;

public class HelloEvent {

    String data;

    public HelloEvent(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
