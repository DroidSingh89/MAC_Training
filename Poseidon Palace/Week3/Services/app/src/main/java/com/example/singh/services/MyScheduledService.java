package com.example.singh.services;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;


public class MyScheduledService extends IntentService {


    private static final String TAG = "MyScheduledService";

    public MyScheduledService() {
        super("MyScheduledService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        for (int i = 0; i < 5; i++) {

            Log.d(TAG, "onHandleIntent: "+ i + Thread.currentThread());
            if (i == 5) {
                stopSelf();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }

    }

}
