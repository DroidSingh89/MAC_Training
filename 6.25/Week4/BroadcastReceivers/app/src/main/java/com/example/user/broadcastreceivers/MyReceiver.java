package com.example.user.broadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {


        switch (intent.getAction()) {

            case Intent.ACTION_AIRPLANE_MODE_CHANGED:

                boolean state = intent.getBooleanExtra("state", false);
                Toast.makeText(context, String.valueOf(state), Toast.LENGTH_SHORT).show();
                break;

            case Constants.Action.MY_ACTION:

                String data = intent.getStringExtra(Constants.Key.MY_KEY);
                Toast.makeText(context, data, Toast.LENGTH_SHORT).show();


                break;

        }


    }
}
