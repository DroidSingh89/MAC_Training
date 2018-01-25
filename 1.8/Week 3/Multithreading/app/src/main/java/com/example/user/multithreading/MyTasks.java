package com.example.user.multithreading;

import android.util.Log;

/**
 * Created by singh on 1/23/18.
 */

public class MyTasks {


    public static void startSimpleJob(String TAG) {

        Log.d(TAG, "startSimpleJob: initializing task" );
        for (int i = 0; i < 5; i++) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.d(TAG, "run: "
                    + i
                    + "Thread: "
                    + Thread.currentThread().toString());
        }
        Log.d(TAG, "startSimpleJob: Task completed");
    }
}
