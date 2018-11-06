package com.example.user.broadcastreceivers;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.user.broadcastreceivers.receivers.MyStaticReceiver;

public class MainActivity extends AppCompatActivity {

    private MyStaticReceiver myStaticReceiver;
    private EditText etMain;
    private TextView tvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etMain = findViewById(R.id.etMain);
        tvMain = findViewById(R.id.tvMain);
    }

    @Override
    protected void onStart() {
        super.onStart();
        myStaticReceiver = new MyStaticReceiver(tvMain);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        intentFilter.addAction(Intent.ACTION_HEADSET_PLUG);
        intentFilter.addAction(StringManipulator.ACTION_STRING_MANIPULATOR);
        registerReceiver(myStaticReceiver, intentFilter);

    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(myStaticReceiver);
    }

    public void onStringManipulation(View view) {

        String stringToManipulate = etMain.getText().toString();
        StringManipulator stringManipulator = new StringManipulator(stringToManipulate, this);
        stringManipulator.start();

    }
}
