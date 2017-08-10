package com.example.user.multithreadingandroid;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by singh on 8/8/17.
 */

public class TestRunnable implements Runnable {


    Handler handler = new Handler(Looper.getMainLooper());

    TextView textView;
    int i;

    public TestRunnable(TextView textView) {
        this.textView = textView;
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread());

        for (i = 0; i < 5; i++) {

            try {
                Thread.sleep(1000);
                System.out.println(String.valueOf(i));
                Log.d("TAG", "run: " + i);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        textView.setText(String.valueOf(i));


                    }
                }, 2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }





        }


    }
}
