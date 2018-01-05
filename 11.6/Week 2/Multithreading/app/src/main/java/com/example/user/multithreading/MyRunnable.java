package com.example.user.multithreading;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by singh on 11/14/17.
 */

public class MyRunnable implements Runnable{


    TextView textView;
    Handler handler = new Handler(Looper.getMainLooper());

    private static final String TAG = "MyRunnable";


    public MyRunnable(TextView textView) {
        this.textView = textView;
    }

    int i;
    @Override
    public void run() {

        for (i = 0; i < 5; i++) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.d(TAG, "run: " + Thread.currentThread() + " : " + i);

            //update the textview
            handler.post(new Runnable() {
                @Override
                public void run() {
                    textView.setText("" + i + Thread.currentThread());

                }
            });







        }



    }
}
