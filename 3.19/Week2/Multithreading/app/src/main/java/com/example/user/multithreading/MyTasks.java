package com.example.user.multithreading;

import android.util.Log;

public class MyTasks {

    public static void startJob(String Tag) {

        for (int i = 0; i < 5; i++) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Log.d(Tag + "_TAG", "run: " + Thread.currentThread() + i);
        }

    }
}
