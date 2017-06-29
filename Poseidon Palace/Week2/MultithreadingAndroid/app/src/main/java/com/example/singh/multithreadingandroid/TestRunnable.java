package com.example.singh.multithreadingandroid;

import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by singh on 6/28/17.
 */

public class TestRunnable implements Runnable {


    int i;
    TextView textViewPost, textViewDelayed;
    Handler handler = new Handler(Looper.getMainLooper());

    public TestRunnable(TextView textViewPost, TextView textViewDelayed) {
        this.textViewPost = textViewPost;
        this.textViewDelayed = textViewDelayed;
    }

    @Override
    public void run() {


        for (i = 0; i < 10; i++) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            handler.post(new Runnable() {
                @Override
                public void run() {

                    textViewPost.setText(String.valueOf(i));

                }
            });

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    textViewDelayed.setText(String.valueOf(i-2));
                }
            }, 2000);

            EventBus.getDefault().post(new HelloEvent("Hello: " + String.valueOf(i)));
            System.out.println( "Counter: " + i + "Thread: " + Thread.currentThread());

        }



    }
}
