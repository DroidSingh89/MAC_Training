package com.example.user.services.services;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.util.Log;

import static android.content.ContentValues.TAG;

public class MyIntentService extends IntentService {

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

        int iterations = intent.getIntExtra("iterations", 4);

        for (int i = 0; i < iterations; i++) {
            try {
                Thread.sleep(500);
                Log.d(TAG, "onHandleIntent: "+ i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }
}
