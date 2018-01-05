package com.example.user.multithreading;

import android.util.Log;

/**
 * Created by singh on 12/5/17.
 */

public class MyTasks {


    private static final String TAG = "MyTasksTag";

    public static String startTask(String initialString) {
        Log.d(TAG, "run: init data: " + initialString);
        Log.d(TAG, "run: Thread info: " + Thread.currentThread());

        for (int i = 0; i < 6; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.d(TAG, "run: progress" + i);

        }
        Log.d(TAG, "run: status: Task complete");
        return "Task Completed";

    }
}
