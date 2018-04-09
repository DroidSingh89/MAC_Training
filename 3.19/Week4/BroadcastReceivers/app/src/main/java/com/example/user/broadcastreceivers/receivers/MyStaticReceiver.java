package com.example.user.broadcastreceivers.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import static android.content.ContentValues.TAG;

public class MyStaticReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.d(TAG, "onReceive: ");

        switch (intent.getAction()) {
            case Intent.ACTION_AIRPLANE_MODE_CHANGED:

                boolean status = intent.getBooleanExtra("state", false);

                Toast.makeText(context, "Airplane mode " + status, Toast.LENGTH_SHORT).show();

                break;
        }
    }
}
