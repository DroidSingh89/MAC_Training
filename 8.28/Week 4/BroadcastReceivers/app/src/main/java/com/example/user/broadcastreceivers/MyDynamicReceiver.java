package com.example.user.broadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by singh on 9/20/17.
 */

public class MyDynamicReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {


        String toastString = "";
        switch (intent.getAction()) {

            case Intent.ACTION_AIRPLANE_MODE_CHANGED:
                boolean isAirplaneModeOn = intent.getBooleanExtra("state", false);

                if (isAirplaneModeOn)
                    toastString = "Airplane on";
                else
                    toastString = "Airplane off";
                break;

            case "myAction":
                toastString = intent.getStringExtra("data");
                break;
        }

        Toast.makeText(context, toastString, Toast.LENGTH_SHORT).show();


    }


}
