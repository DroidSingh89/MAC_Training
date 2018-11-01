package com.example.user.multithreading.utils;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class HandlerUtils {

    public static void sendMessage(Handler handler, String value) {

        Bundle bundle = new Bundle();
        Message message = new Message();
        bundle.putString("value", value);
        message.setData(bundle);
        handler.sendMessage(message);

    }

    public static String getString(Message message){
        return message.getData().getString("value");
    }

}
