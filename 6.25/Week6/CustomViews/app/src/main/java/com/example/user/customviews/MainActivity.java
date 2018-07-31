package com.example.user.customviews;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.user.customviews.view.MyCircleView;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class MainActivity extends AppCompatActivity {

    private MyCircleView myCircleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myCircleView = findViewById(R.id.myCircleView);

        fetchResult();
    }

    public void updateCircleRadius(View view) {

        myCircleView.setRadius(50);

    }

    public void updateCircleColor(View view) {
    }


    private static final String RESULT = "count";



    private void fetchResult() {
        final SharedPreferences prefs =
                getSharedPreferences("result", Context.MODE_PRIVATE);

        HandlerThread thread1 = new HandlerThread("thread1");
        HandlerThread thread2 = new HandlerThread("thread2");
        thread1.start();
        thread2.start();

        final CountDownLatch latchA = new CountDownLatch(3);
        final CountDownLatch latchB = new CountDownLatch(1);

        Handler handler1 = new Handler(thread1.getLooper());
        handler1.post(new Runnable() {
            @Override
            public void run() {
                prefs.edit().putInt(RESULT, 4).apply();
                latchB.countDown();//b: 0

                try {
                    latchA.await();
                } catch (InterruptedException e) { }
                prefs.edit().putInt(RESULT, 8).apply();
            }
        });

                Handler handler2 = new Handler(thread2.getLooper());
        handler2.post(new Runnable() {
            @Override
            public void run() {
                prefs.edit().putInt(RESULT, 10).apply();
                latchA.countDown();//A: 2

                try {
                    latchB.await();
                    latchA.countDown();//A:1
                } catch (Exception e) { }
                prefs.edit().putInt(RESULT, 19).apply();
            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                int result = prefs.getInt(RESULT, 12);
                Log.d("Result", "Result is: " + result);
            }
        }, 2000);
    }

}
