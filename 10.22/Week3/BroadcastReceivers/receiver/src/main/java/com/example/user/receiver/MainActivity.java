package com.example.user.receiver;

import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.user.receiver.receiver.MyReceiver;

public class MainActivity extends AppCompatActivity {


    private static final String ACTION_SEND_OUTSIDE = "action.SEND_DATA_OUTSIDE";
    private MyReceiver myReceiver;
    private TextView tvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvMain = findViewById(R.id.tvMain);
    }

    @Override
    protected void onStart() {
        super.onStart();
        myReceiver = new MyReceiver(tvMain);
        IntentFilter intentFilter = new IntentFilter(ACTION_SEND_OUTSIDE);
        LocalBroadcastManager.getInstance(this).registerReceiver(myReceiver, intentFilter);

//        if receiver want to listen to broadcast locally
//        LocalBroadcastManager.getInstance(this).registerReceiver(myReceiver, intentFilter);
    }

//    should unregister on the onDestroy to listen to broadcast from other apps
    @Override
    protected void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(myReceiver);

//        if receiver want to listen to broadcast locally
//        LocalBroadcastManager.getInstance(this).unregisterReceiver(myReceiver);

    }
}
