package com.example.user.makingrestcalls;

import android.os.Bundle;
import android.os.Message;

/**
 * Created by singh on 12/18/17.
 */

public class MessageUtil {


    public static Message getMessage(String data) {
        Bundle bundle = new Bundle();
        bundle.putString("data", data);

        Message message = new Message();
        message.setData(bundle);
        return message;

    }

    public static String getResponse(Message message){
        return message.getData().getString("data");
    }
}
