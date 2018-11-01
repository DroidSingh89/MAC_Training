package com.example.user.multithreading.jobs;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.example.user.multithreading.MyTask;
import com.example.user.multithreading.utils.HandlerUtils;

public class MyRunnable implements Runnable {

    int iterations;
    Handler handler;

    public MyRunnable(int iterations, Handler handler) {
        this.iterations = iterations;
        this.handler = handler;
    }

    @Override
    public void run() {

        HandlerUtils.sendMessage(handler,"Task starting");


//        start the task
        try {

            MyTask.start(iterations, Thread.currentThread().getName());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        HandlerUtils.sendMessage(handler, "Task completed");


    }
}
