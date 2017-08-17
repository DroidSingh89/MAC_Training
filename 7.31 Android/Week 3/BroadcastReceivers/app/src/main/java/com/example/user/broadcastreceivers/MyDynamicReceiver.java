package com.example.user.broadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by singh on 8/15/17.
 */

public class MyDynamicReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "I am dynamic", Toast.LENGTH_SHORT).show();

    }
}
