package com.example.user.broadcastreceivers.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyStaticReceiver extends BroadcastReceiver {

    private static final String TAG = "MyStaticReceiverTag";

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.d(TAG, "onReceive: ");

    }
}
