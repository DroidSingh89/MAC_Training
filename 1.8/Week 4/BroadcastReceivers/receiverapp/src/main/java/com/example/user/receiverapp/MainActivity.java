package com.example.user.receiverapp;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements MyReceiverOne.OnBroadcastInteraction{

    private MyReceiverOne myReceiverOne;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.tvMain);
    }

    @Override
    protected void onStart() {
        super.onStart();

        myReceiverOne = new MyReceiverOne(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("myActionOutside");
        registerReceiver(myReceiverOne, intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myReceiverOne);
    }

    @Override
    public void onBroadcastReceived(String data) {
        textView.setText(data);
    }
}
