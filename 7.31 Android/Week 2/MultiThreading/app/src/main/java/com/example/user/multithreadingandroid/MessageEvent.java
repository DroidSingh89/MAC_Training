package com.example.user.multithreadingandroid;

/**
 * Created by singh on 8/8/17.
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
