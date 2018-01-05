package com.example.user.services.services;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


public class MyIntentService extends IntentService {

    private static final String TAG = "MyIntentService";

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");

    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(TAG, "onHandleIntent: "
                + intent.getStringExtra("data") + " "
                + Thread.currentThread());

        switch (intent.getAction()) {

            case "Task1":

                Log.d(TAG, "onHandleIntent: Executing task 1");
                for (int i = 0; i < 5; i++) {
                    try {
                        Log.d(TAG, "onHandleIntent: Task completion: " + i);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Log.d(TAG, "onHandleIntent: Completed Task 1");
                break;


            case "Task2":
                Log.d(TAG, "onHandleIntent: Executing task 2");
                List<String> stringList = new ArrayList<>();
                stringList.add("string 1");
                stringList.add("string 2");
                stringList.add("string 3");
                for (String s : stringList) {
                    Log.d(TAG, "onHandleIntent: Task success for " + s);
                }
                Log.d(TAG, "onHandleIntent: Completed Task 2");
                break;

        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }
}
