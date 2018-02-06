package com.example.user.makingrestcalls;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

/**
 * Created by singh on 2/6/18.
 */

public class HandlerUtils {


    public static final int MODE_HTTP = 1;
    public static final int MODE_OKHTTP = 2;

    public static HandlerUtils instance = null;
    Handler handler;
    private Message message;
    private Bundle bundle;

    public static HandlerUtils getDefault() {

        if (instance == null)
            instance = new HandlerUtils();
        return instance;
    }

    public void setReceiver(Handler handler) {
        this.handler = handler;
        message = new Message();
        bundle = new Bundle();

    }


    public void sendStringToMain(String msg, int MODE) {

        switch (MODE) {
            case MODE_HTTP:
                bundle.putString("data", msg);
                message.what = MODE_HTTP;
                break;

            case MODE_OKHTTP:
                bundle.putString("okhttpSync", msg);
                message.what = MODE_OKHTTP;

                break;
        }
        message.setData(bundle);
        handler.sendMessage(message);
    }
}
