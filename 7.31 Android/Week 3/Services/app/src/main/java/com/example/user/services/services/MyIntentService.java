package com.example.user.services.services;

import android.app.IntentService;
import android.content.Intent;
import android.os.Parcelable;
import android.util.Log;

public class MyIntentService extends IntentService {


    private static final String TAG = "MyIntentServiceTAG";

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

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        switch (intent.getAction()){

            case "getRepo":
                Log.d(TAG, "onHandleIntent: "+ intent.getStringExtra("data") + Thread.currentThread());
                break;

            case "getProfile":
                Log.d(TAG, "onHandleIntent: "+ intent.getStringExtra("data") + Thread.currentThread());
                break;
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.d(TAG, "onDestroy: ");
    }
}
