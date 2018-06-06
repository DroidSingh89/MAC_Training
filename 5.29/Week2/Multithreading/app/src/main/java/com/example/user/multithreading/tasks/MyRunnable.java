package com.example.user.multithreading.tasks;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.example.user.multithreading.utils.HandlerUtils;


public class MyRunnable implements Runnable{

    Handler handler;

    public MyRunnable(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void run() {

        HandlerUtils.with(handler).sendMessage("Executing Thread");


        try {
            TaskFactory.createSimpleTask(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        HandlerUtils.with(handler).sendMessage("Task completed");
    }
}
