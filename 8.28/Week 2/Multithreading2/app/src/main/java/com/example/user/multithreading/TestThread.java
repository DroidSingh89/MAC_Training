package com.example.user.multithreading;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by singh on 9/7/17.
 */

public class TestThread extends Thread {


    TextView tvCounter;
    Handler handler = new Handler(Looper.getMainLooper());

    public TestThread(TextView tvCounter) {
        this.tvCounter = tvCounter;
    }

    private static final String TAG = "TestThreadTag";
    int i;

    @Override
    public void run() {
        super.run();

        for (i = 0; i < 5; i++) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            handler.post(new Runnable() {
                @Override
                public void run() {

                    tvCounter.setText(String.valueOf(i));

                }
            });

            Log.d(TAG, "run: " + i + " " + Thread.currentThread());

            TestRunnable testRunnable = new TestRunnable(tvCounter);
            handler.postDelayed(testRunnable, 1000);
        }


    }
}
