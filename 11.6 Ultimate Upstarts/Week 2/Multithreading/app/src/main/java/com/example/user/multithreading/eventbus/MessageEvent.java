package com.example.user.multithreading.eventbus;

/**
 * Created by singh on 11/15/17.
 */

public class MessageEvent {

    String data;

    public MessageEvent(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
