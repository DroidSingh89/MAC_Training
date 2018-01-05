package com.example.user.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by singh on 12/14/17.
 */

public class MyReceiver extends BroadcastReceiver{

    private static final String TAG = "MyReceiverTag";

    @Override
    public void onReceive(Context context, Intent intent) {

         Log.d(TAG, "onReceive: " + intent.getStringExtra("data"));
    }
}
