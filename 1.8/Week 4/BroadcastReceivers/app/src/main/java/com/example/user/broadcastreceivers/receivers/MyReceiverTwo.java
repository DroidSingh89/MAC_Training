package com.example.user.broadcastreceivers.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by singh on 1/31/18.
 */

public class MyReceiverTwo extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.d(TAG, "onReceive: ");
        String action = intent.getAction();

        switch (action) {
            case Intent.ACTION_AIRPLANE_MODE_CHANGED:

                boolean isAirplaneMode =
                        intent.getBooleanExtra("state", false);

                if (isAirplaneMode) {
                    Toast.makeText(context, "Airplane on", Toast.LENGTH_SHORT).show();
                } else Toast.makeText(context, "Airplane off", Toast.LENGTH_SHORT).show();

                break;

            case "myAction":
                Toast.makeText(context, intent.getStringExtra("data"), Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
