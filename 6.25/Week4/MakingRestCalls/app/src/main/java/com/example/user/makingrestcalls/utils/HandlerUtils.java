package com.example.user.makingrestcalls.utils;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class HandlerUtils {

    private static HandlerUtils instance = null;
    private static final String STRING_KEY = "stringKey";

    Handler handler;
    Handler.Callback callback;

    private HandlerUtils() {
//        denies initialiation
        //
    }


    public static HandlerUtils getDefault() {

        if (instance == null) {
            instance = new HandlerUtils();
        }
        return instance;


    }

    public void registerOwner(Handler.Callback callback) {


        this.callback = callback;
        this.handler = new Handler((callback));

    }

    public void unregisterOwner(Handler.Callback callback) {



        if (callback instanceof Handler.Callback) {

            this.callback = null;
            this.handler = null;
        }

    }


    public void sendMessage(String data) {

        Message message = new Message();
        Bundle bundle = new Bundle();
        bundle.putString(STRING_KEY, data);
        message.setData(bundle);
        handler.sendMessage(message);
    }


    public String parseMessage(Message message) {

        return message.getData().getString(STRING_KEY);
    }



}
