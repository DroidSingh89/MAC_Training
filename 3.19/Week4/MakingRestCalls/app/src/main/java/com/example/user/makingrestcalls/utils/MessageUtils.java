package com.example.user.makingrestcalls.utils;

import android.os.Message;

public class MessageUtils {

    public static String getMessage(Message message) {

        return message.getData().getString(Constants.KEY.RESULT);
    }
}
