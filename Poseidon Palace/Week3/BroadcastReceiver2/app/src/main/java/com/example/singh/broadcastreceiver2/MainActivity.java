package com.example.singh.broadcastreceiver2;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MyReceiver";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    MyReceiver myReceiver;

    @Override
    protected void onStart() {
        super.onStart();

        myReceiver = new MyReceiver();

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("sendingToOtherApp");
        registerReceiver(myReceiver, intentFilter);


    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myReceiver);
    }

}
