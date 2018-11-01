package com.example.user.multithreading;

import android.util.Log;

public class MyTask {

    private static final String TAG = MyTask.class.getSimpleName() + "_TAG";

    public static void start(int iterations, String thread) throws InterruptedException {


        Log.d(TAG, "start: Task starting on Thread: " + thread);

        for (int i = 0; i < iterations; i++) {

            Thread.sleep(500);
            Log.d(TAG, "start: iteration: " + i);

        }

        Log.d(TAG, "start: Task completed on Thread: " + thread);
    }
}
