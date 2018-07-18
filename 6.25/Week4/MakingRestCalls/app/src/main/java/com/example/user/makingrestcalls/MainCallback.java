package com.example.user.makingrestcalls;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import com.example.user.makingrestcalls.utils.HandlerUtils;

public class MainCallback implements Handler.Callback {

    Context context;

    public MainCallback(Context context) {
        this.context = context;
    }

    @Override
    public boolean handleMessage(Message message) {

        String data = HandlerUtils.getDefault().parseMessage(message);

        Toast.makeText(context, data, Toast.LENGTH_SHORT).show();
        return false;
    }
}
