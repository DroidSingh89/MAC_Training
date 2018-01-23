package com.example.user.multithreading.threads;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.TextView;

import com.example.user.multithreading.MyTasks;



/**
 * Created by singh on 1/23/18.
 */

public class MyThread extends Thread {


    private static final String TAG = MyThread.class.getSimpleName();

    TextView tvMain;
    Handler handler = new Handler(Looper.getMainLooper());


    public MyThread(TextView tvMain) {
        this.tvMain = tvMain;
    }

    @Override
    public void run() {
        super.run();

        //update the textview for init the task
        handler.post(new Runnable() {
            @Override
            public void run() {
                tvMain.setText("Task in progress");
            }
        });

        //do the task
        MyTasks.startSimpleJob(TAG);

        //update the view after task is done
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                tvMain.setText("Task completed");
            }
        }, 3000);

    }
}
