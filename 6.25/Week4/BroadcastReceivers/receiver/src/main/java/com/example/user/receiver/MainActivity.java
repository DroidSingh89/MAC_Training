package com.example.user.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    public static final String ACTION_OUTSIDE = "actionOut";
    public static final String MY_KEY = "myKey";

    MyReceiver myReceiver;
    IntentFilter intentFilter;
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
        myReceiver = new MyReceiver();
        intentFilter = new IntentFilter(ACTION_OUTSIDE);
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

    public class MyReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {

            textView.setText(intent.getStringExtra(MY_KEY));

        }
    }
}
