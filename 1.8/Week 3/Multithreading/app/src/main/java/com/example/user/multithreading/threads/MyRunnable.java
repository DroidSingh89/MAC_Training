package com.example.user.multithreading.threads;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.example.user.multithreading.MyTasks;



/**
 * Created by singh on 1/23/18.
 */

public class MyRunnable implements Runnable {


    private static final String TAG = MyRunnable.class.getSimpleName();


    Handler handler;

    public MyRunnable(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void run() {


        sendMessage("Task in progress");

        //do the task
        MyTasks.startSimpleJob(TAG);

        sendMessage("Task completed");

    }

    private void sendMessage(String data) {
        Bundle bundle = new Bundle();
        bundle.putString("KEY", data);
        Message message = new Message();
        message.setData(bundle);
        handler.sendMessage(message);
    }
}
