package com.example.user.multithreading.tasks;

import android.util.Log;

public class TaskFactory {

    public static void createSimpleTask(Object worker) throws InterruptedException {

        String TAG = worker.getClass().getSimpleName()+ "_TAG";


        Log.d(TAG, "createSimpleTask: Starting task on "+ Thread.currentThread().getName());

        for (int i = 0; i < 5; i++) {
            Log.d(TAG, "createSimpleTask: Task status: " + i);

            Thread.sleep(500);
        }

        Log.d(TAG, "createSimpleTask: Task Complete");


    }
}
