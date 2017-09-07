package com.example.user.multithreading;

/**
 * Created by singh on 9/7/17.
 */

public class MessageEvent {
    String message;


    public MessageEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
