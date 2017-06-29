package com.example.singh.multithreadingandroid;

import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by singh on 6/28/17.
 */

public class TestThread extends Thread {


    TextView tvResultPost, tvResultDelayed;
    Handler handler = new Handler(Looper.getMainLooper());

int i;
    public TestThread(TextView tvResultPost, TextView tvResultDelayed) {
        this.tvResultPost = tvResultPost;
        this.tvResultDelayed = tvResultDelayed;
    }

    @Override
    public void run() {
        super.run();


        for (i = 0; i < 10; i++) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            handler.post(new Runnable() {
                @Override
                public void run() {

               tvResultPost.setText(String.valueOf(i));

                }
            });

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    tvResultDelayed.setText(String.valueOf(i));

                }
            }, 2000);

            EventBus.getDefault().post(new StuffEvent("Stuff"));

            System.out.println( "Counter: " + i + " " + Thread.currentThread());

        }

    }
}
