package com.example.user.multithreading;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by singh on 10/3/17.
 */

public class MyThread extends Thread {

    private static final String TAG = "MyThreadTag";

    Handler handler;

    public MyThread(Handler handler) {
        this.handler = handler;
    }


    @Override
    public void run() {

        int total = 0;

        //sum the total
        for (int i = 0; i < 5; i++) {
            //log the i with the current thread
            Log.d(TAG, "run: " + i + " Thread: " + Thread.currentThread());
            try {
                Thread.sleep(1000);// make the thread wait for 1 sec
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            total = total +  i;

        }

        //send the results back to the UI thread using a handler message

        //add the results to the bundle object
        Bundle bundle  =new Bundle();
        bundle.putInt("total", total);
        //add the bundle to the message object
        Message message = new Message();
        message.setData(bundle);
        //send the message back using the handler
        handler.sendMessage(message);


        //send the message usign Eventbus
        EventBus.getDefault().post(new HelloEvent(String.valueOf(total)));


    }
}
