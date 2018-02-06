package com.example.user.receiverapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import static android.content.ContentValues.TAG;

public class MyReceiverOne extends BroadcastReceiver {

    OnBroadcastInteraction onBroadcastInteraction;

    public MyReceiverOne(OnBroadcastInteraction onBroadcastInteraction) {
        this.onBroadcastInteraction = onBroadcastInteraction;
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.d(TAG, "onReceive: ");
        onBroadcastInteraction
                .onBroadcastReceived(intent.getStringExtra("data"));

    }


    public interface OnBroadcastInteraction {

        void onBroadcastReceived(String data);
    }



}
