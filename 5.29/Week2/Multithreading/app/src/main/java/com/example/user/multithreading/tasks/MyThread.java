package com.example.user.multithreading.tasks;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.TextView;

import com.example.user.multithreading.model.MyEvent;

import org.greenrobot.eventbus.EventBus;

public class MyThread extends Thread {

    TextView tvResult;
    Handler handler = new Handler(Looper.getMainLooper());

    public MyThread(TextView tvResult) {
        this.tvResult = tvResult;
    }

    @Override
    public void run() {
        super.run();

//        using eventbus to post
        MyEvent myEvent = new MyEvent("Starting task");
        EventBus.getDefault().post(myEvent);

        handler.post(new Runnable() {
            @Override
            public void run() {
                tvResult.setText("Executing task");
            }
        });


        try {
            TaskFactory.createSimpleTask(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        handler.post(new Runnable() {
            @Override
            public void run() {
                tvResult.setText("Task completed");
            }
        });

//        using eventbus to posts
        myEvent.setData("Task completed");
        EventBus.getDefault().post(myEvent);

    }

}
