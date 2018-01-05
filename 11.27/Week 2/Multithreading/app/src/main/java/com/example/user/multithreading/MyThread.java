package com.example.user.multithreading;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by singh on 12/5/17.
 */

public class MyThread extends Thread {

    private static final String TAG = "MyThreadTag";

    String initialString;
    TextView tvDisplayData;
    int i;

    //create a handler object to update the ui in this thread
    Handler handler = new Handler(Looper.getMainLooper());

    public MyThread(String initialString, TextView tvDisplayData) {
        this.initialString = initialString;
        this.tvDisplayData = tvDisplayData;
    }


    @Override
    public void run() {
        super.run();

        handler.post(new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, "run: " + Thread.currentThread());
                tvDisplayData.setText(initialString);
            }
        });

        Log.d(TAG, "run: init data: " + initialString);
        Log.d(TAG, "run: Thread info: " + Thread.currentThread());

        for (i= 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.d(TAG, "run: progress" + i);

            handler.post(new Runnable() {
                @Override
                public void run() {
                    tvDisplayData.setText(String.valueOf(i));
                }
            });


        }
        Log.d(TAG, "run: status: Task complete");

        handler.post(new Runnable() {
            @Override
            public void run() {
                tvDisplayData.setText("Task complete");
            }
        });



    }
}
