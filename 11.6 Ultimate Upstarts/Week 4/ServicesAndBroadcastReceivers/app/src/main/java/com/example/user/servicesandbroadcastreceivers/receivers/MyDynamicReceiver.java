package com.example.user.servicesandbroadcastreceivers.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.TextView;

public class MyDynamicReceiver extends BroadcastReceiver {


    private static final String TAG = "MyDynamicReceiver";

    TextView textView;

    public MyDynamicReceiver(TextView textView) {
        this.textView = textView;
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        String receivedData = intent.getStringExtra("data");
        Log.d(TAG, "onReceive: " + receivedData);

        textView.setText(receivedData);

    }
}
