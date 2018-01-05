package com.example.user.broadcastreceivers;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyStaticReceiver extends BroadcastReceiver {

    private static final String TAG = "MyReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {

        switch (intent.getAction()) {

            case "myAction":

                Log.d(TAG, "onReceive: " + "myAction");
                break;

            case "myAction2":

                Log.d(TAG, "onReceive: " + "myAction2");
                break;
            case Intent.ACTION_AIRPLANE_MODE_CHANGED:
                Log.d(TAG, "onReceive: " + "Airplane");


                break;


        }

    }
}
