package com.example.user.multithreading.utils;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class HandlerUtils {

    private static HandlerUtils instance = null;
    Handler handler;

    private HandlerUtils() {
        //avoid initialization of this class
    }

    public static HandlerUtils with(Handler handler) {

        if (instance == null) {
            instance = new HandlerUtils(handler);
        }
        instance.setHandler(handler);
        return instance;
    }

    private HandlerUtils(Handler handler) {
        this.handler = handler;
    }

    private void setHandler(Handler handler) {
        this.handler = handler;
    }

    public void sendMessage(String MESSAGE) {
        Message message = new Message();
        Bundle bundle = new Bundle();
        bundle.putString("data", MESSAGE);
        message.setData(bundle);
        handler.sendMessage(message);

    }


}
