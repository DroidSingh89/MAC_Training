package com.example.user.multithreadingandroid;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

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

        String data = "Message from TestThreadHandlerMessage";
        System.out.println("run: Thread: " + Thread.currentThread() + "Data: " + data);

        //Adding the data to be sent to the bundle
        Bundle bundle = new Bundle();
        bundle.putString("KEY_DATA", data);

        //Add the bundle to the message object
        Message message = new Message();
        message.setData(bundle);

        //send the message object to the handler
        handler.sendMessage(message);

    }
}
