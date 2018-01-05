package com.example.user.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.user.broadcastreceiver.utils.Constants;

/**
 * Created by singh on 10/10/17.
 */

public class MyDynamicReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        String action = intent.getAction();

        switch (action) {

            case Intent.ACTION_AIRPLANE_MODE_CHANGED:

                boolean isAirplaneModeOn = intent.getBooleanExtra("state", false);

                if (isAirplaneModeOn)
                    Toast.makeText(context, "Airplane mode is on", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(context, "Airplane mode is off", Toast.LENGTH_SHORT).show();

                break;


            case Constants.ACTION.ACTION1:

                String data = intent.getStringExtra(Constants.KEYS.DATA_MAIN);
                Toast.makeText(context, data, Toast.LENGTH_SHORT).show();

                break;

            case "action2":

                break;

        }

    }
}
