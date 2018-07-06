package com.example.user.multithreading.workers;

import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;

import com.example.user.multithreading.utils.TaskCreator;

public class MyThread extends Thread {

    TextView tvMain;
    Handler handler;

    public MyThread(TextView tvMain) {
        this.tvMain = tvMain;
        this.handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void run() {
        super.run();

//        before the task is started
        handler.post(new Runnable() {
            @Override
            public void run() {
                tvMain.setText("Task starting");
            }
        });

//        task in execution
        try {

            TaskCreator.createSimpleTask(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        task completed
        handler.post(new Runnable() {
            @Override
            public void run() {
                tvMain.setText("Task Completed");
            }
        });


    }
}
