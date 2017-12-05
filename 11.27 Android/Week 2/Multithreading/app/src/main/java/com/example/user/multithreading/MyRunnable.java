package com.example.user.multithreading;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by singh on 12/5/17.
 */

public class MyRunnable implements Runnable {


    Handler handler;

    public MyRunnable(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void run() {

//        start the task
        String result = MyTasks.startTask("Task in a runnable");

//        pass the results back to the main thread
        Bundle bundle = new Bundle();
        bundle.putString("result", result);

        Message message = new Message();
        message.setData(bundle);

        handler.sendMessage(message);

        //send person object using eventbus
        EventBus.getDefault().post(new PersonEvent("John Doe","45"));


    }
}
