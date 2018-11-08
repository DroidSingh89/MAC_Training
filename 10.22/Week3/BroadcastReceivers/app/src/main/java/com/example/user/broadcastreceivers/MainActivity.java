package com.example.user.broadcastreceivers;

import android.Manifest;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.user.broadcastreceivers.receivers.MyStaticReceiver;

public class MainActivity extends AppCompatActivity {

    private static final String ACTION_SEND_OUTSIDE = "action.SEND_DATA_OUTSIDE";
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

    public void onSendingDataOutside(View view) {

        Intent intent = new Intent(ACTION_SEND_OUTSIDE);
        intent.putExtra("KEY", "Data from app module");

//        using a system level permission
//        sendBroadcast(intent, Manifest.permission.INTERNET);

//        using a custom permission
        sendBroadcast(intent, "user.permission.MY_PERMISSION");

//        restricting the broadcast locally to the app
//        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);





    }
}
