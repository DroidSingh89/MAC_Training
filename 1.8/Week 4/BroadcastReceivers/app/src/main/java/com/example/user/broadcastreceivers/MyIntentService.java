package com.example.user.broadcastreceivers;

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
    protected void onHandleIntent(Intent intent) {

        Log.d(TAG, "onHandleIntent: ");
        Intent broadCastIntent = new Intent("myAction");
        broadCastIntent.putExtra("data", intent.getStringExtra("data"));
        sendBroadcast(broadCastIntent);


    }
}
