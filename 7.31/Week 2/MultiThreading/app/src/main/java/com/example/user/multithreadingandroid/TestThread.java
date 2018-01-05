package com.example.user.multithreadingandroid;

import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by singh on 8/8/17.
 */

public class TestThread extends Thread {

    Handler handler = new Handler(Looper.getMainLooper());
    TextView tvTesting;

    public TestThread(TextView tvTesting) {
        this.tvTesting = tvTesting;
    }


    int i;

    @Override
    public void run() {
        super.run();

        System.out.println(Thread.currentThread());

        for (i = 0; i < 10; i++) {

            try {
                Thread.sleep(1000);
                System.out.println(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            handler.post(new Runnable() {
                @Override
                public void run() {

                    tvTesting.setText(String.valueOf(i));

                }
            });

            EventBus.getDefault().post(new MessageEvent(String.valueOf(i)));

        }


    }
}
