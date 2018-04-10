package com.example.user.makingrestcalls.utils;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class HandlerUtils {

    public static HandlerUtils instance = null;
    Handler handler;

    private HandlerUtils() {
    }

    public static class Mode{
        public static final String NATIVE = "native";
        public static final String OKHTTP = "okhttp";
        public static final String RETROFIT = "retrofit";
    }

    public static HandlerUtils getDefault() {
        if (instance == null) {
            instance = new HandlerUtils();
        }
        return instance;
    }

    public void setReceiver(Handler handler) {
        this.handler = handler;
    }

    public void sendMessage(String message, String mode) {


        Message handlerMessage = new Message();
        Bundle bundle = new Bundle();

        switch (mode) {
            case Mode.NATIVE:
                bundle.putString(Constants.KEY.RESULT, message);
                handlerMessage.setData(bundle);
                handler.sendMessage(handlerMessage);

                break;
            case Mode.OKHTTP:


                break;
        }


    }


}
