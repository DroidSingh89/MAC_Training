package com.example.user.multithreading.threads;

import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;

import com.example.user.multithreading.MyTasks;


public class MyThread extends Thread {

    Handler handler = new Handler(Looper.getMainLooper());

    TextView tvMain;

    public MyThread(TextView tvMain) {
        this.tvMain = tvMain;
    }


    @Override
    public void run() {
        super.run();


        handler.post(new Runnable() {
            @Override
            public void run() {
                tvMain.setText("Starting job");
            }
        });

        //start the task
        MyTasks.startJob(this.getName());

        handler.post(new Runnable() {
            @Override
            public void run() {
                tvMain.setText("Task completed");

            }
        });


    }
}
