package com.example.singh.broadcastreceiver2;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by singh on 7/6/17.
 */

public class  MyReceiver extends BroadcastReceiver {


    private static final String TAG = "MyReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive: " + intent.getStringExtra("newString"));

        Toast.makeText(context, intent.getStringExtra("newString"), Toast.LENGTH_SHORT).show();

    }
}

