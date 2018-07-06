package com.example.user.multithreading.workers;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.example.user.multithreading.utils.TaskCreator;

public class MyRunnable implements Runnable {


    Handler handler;

    public MyRunnable(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void run() {

        Message message = new Message();
        Bundle bundle = new Bundle();
        bundle.putString("data", "Task starting");
        message.setData(bundle);


//        before the task is starting
        handler.sendMessage(message);


//        during the execution
        try {
            TaskCreator.createSimpleTask(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        after the task is completed
        Message message1 = new Message();
        bundle.putString("data", "Task completed");
        message1.setData(bundle);
        handler.sendMessage(message1);
    }
}
