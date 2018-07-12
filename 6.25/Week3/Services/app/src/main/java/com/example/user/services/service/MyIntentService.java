package com.example.user.services.service;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;


public class MyIntentService extends IntentService {

    private static final String TAG = MyIntentService.class.getSimpleName() + "_TAG";


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
        Log.d(TAG, "onHandleIntent: ");
        Log.d(TAG, "onHandleIntent: Thread: "
                + Thread.currentThread().getName());

        Log.d(TAG, "onHandleIntent: Task starting");


        for (int i = 0; i < 4; i++) {
            try {
                Thread.sleep(500);
                Log.d(TAG, "onHandleIntent: " + i);


            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        Log.d(TAG, "onHandleIntent: Task complete");




    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }
}
