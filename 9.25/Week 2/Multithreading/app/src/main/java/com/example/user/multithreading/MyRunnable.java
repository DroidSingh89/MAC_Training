package com.example.user.multithreading;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.TextView;


/**
 * Created by singh on 10/3/17.
 */

public class MyRunnable implements Runnable {


    TextView textView;

    public MyRunnable(TextView textView) {
        this.textView = textView;
    }

    Handler handler = new Handler(Looper.getMainLooper());

    private static final String TAG = "MyRunnableTag";


    int i ;
    @Override
    public void run() {

        for (i = 0; i < 5; i++) {

            handler.post(new Runnable() {
                @Override
                public void run() {
                    textView.setText(String.valueOf(i));
                }
            });


            //log the i with the current thread
            Log.d(TAG, "run: " + i + " Thread: " + Thread.currentThread());
            try {
                Thread.sleep(1000);// make the thread wait for 1 sec
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
