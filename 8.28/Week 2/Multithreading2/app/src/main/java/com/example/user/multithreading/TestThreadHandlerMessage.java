package com.example.user.multithreading;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import org.greenrobot.eventbus.EventBus;


/**
 * Created by singh on 9/7/17.
 */

public class TestThreadHandlerMessage extends Thread {

    Handler handler;


    public TestThreadHandlerMessage(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void run() {
        super.run();

        String data = "Hi from the TestThreadHandlerMessage";

        //Create a bundle to add it to the message object
        Bundle bundle = new Bundle();
        bundle.putString("data", data);
        //create the message object and add the bundle object
        Message message = new Message();
        message.setData(bundle);
        //send that message object from the handler
        handler.sendMessage(message);

        //Send the message through the eventbus
        EventBus.getDefault().post(new MessageEvent(data));

    }
}
