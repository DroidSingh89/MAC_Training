package com.example.user.myreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    protected void onStart() {
        super.onStart();
        MyReceiver myReceiver= new MyReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction("sendToOtherApp");
        registerReceiver(myReceiver, filter);

    }
}
