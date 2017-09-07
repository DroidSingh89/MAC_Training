package com.example.user.multithreading;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by singh on 9/7/17.
 */

public class TestRunnable implements Runnable {

    TextView tvCounter;
    Handler handler = new Handler(Looper.getMainLooper());


    public TestRunnable(TextView tvCounter) {
        this.tvCounter = tvCounter;
    }

    private static final String TAG = "TestRunnableTag";

    int i;
    @Override
    public void run() {



        for (i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
                Log.d(TAG, "run: " + i + " " + Thread.currentThread());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    tvCounter.setText(String.valueOf(i));
                }
            }, 1000);




        }


    }
}
