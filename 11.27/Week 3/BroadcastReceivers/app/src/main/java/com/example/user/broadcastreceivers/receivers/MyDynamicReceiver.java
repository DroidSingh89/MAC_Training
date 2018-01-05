package com.example.user.broadcastreceivers.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by singh on 12/14/17.
 */

public class MyDynamicReceiver extends BroadcastReceiver {

    OnReceiverInteraction onReceiverInteraction;


    @Override
    public void onReceive(Context context, Intent intent) {

        onReceiverInteraction = (OnReceiverInteraction) context;


        switch (intent.getAction()) {
            case Intent.ACTION_AIRPLANE_MODE_CHANGED:

                boolean isAirplaneModeOn
                        = intent.getBooleanExtra("state", false);

                String stringToBeDisplayed;
                if (isAirplaneModeOn)
                    stringToBeDisplayed = "Airplane mode on";
                else
                    stringToBeDisplayed = "Airplane mode off";


                Toast.makeText(context, stringToBeDisplayed, Toast.LENGTH_SHORT).show();
                break;


            case "myaction":
                //handle the task in the activity
                onReceiverInteraction.onBroadcastReceived(intent);
                break;
        }
    }

    public interface OnReceiverInteraction{
        void onBroadcastReceived(Intent intent);
    }
}
