package com.example.user.multithreading.tasks;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.TextView;

public class MyThread extends Thread {

    TextView tvResult;
    Handler handler = new Handler(Looper.getMainLooper());

    public MyThread(TextView tvResult) {
        this.tvResult = tvResult;
    }

    @Override
    public void run() {
        super.run();

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



    }

}
