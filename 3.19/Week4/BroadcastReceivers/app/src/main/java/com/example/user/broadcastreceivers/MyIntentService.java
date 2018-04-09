package com.example.user.broadcastreceivers;

import android.Manifest;
import android.app.IntentService;
import android.content.Intent;
import android.util.Log;


public class MyIntentService extends IntentService {
    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {


        //some job
        Log.d("MYINTENT_TAG", "onHandleIntent: Job running");
        Intent intent1 = new Intent("myIntentAction");
        intent1.putExtra("result", "Completed");
        Log.d("MYINTENT_TAG", "onHandleIntent: Send broadcast");
        sendBroadcast(intent1, Manifest.permission.INTERNET);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("MYINTENT_TAG", "onDestroy: ");
    }
}
