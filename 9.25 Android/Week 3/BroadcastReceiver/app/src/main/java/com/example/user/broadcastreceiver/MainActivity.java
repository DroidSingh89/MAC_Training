package com.example.user.broadcastreceiver;

import android.Manifest;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.user.broadcastreceiver.utils.Constants;

public class MainActivity extends AppCompatActivity {


    MyDynamicReceiver myDynamicReceiver;
    private EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.etData);
    }


    @Override
    protected void onStart() {
        super.onStart();

        myDynamicReceiver = new MyDynamicReceiver();

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        intentFilter.addAction(Constants.ACTION.ACTION1);

        registerReceiver(myDynamicReceiver, intentFilter);

    }


    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(myDynamicReceiver);
    }

    public void sendBroadcast(View view) {
        String data = editText.getText().toString();

        Intent intent = new Intent();
        intent.setAction(Constants.ACTION.ACTION1);
        intent.putExtra(Constants.KEYS.DATA_MAIN, data);

        sendBroadcast(intent);


    }

    public void sendBroadcastToOtherApp(View view) {

        String data = editText.getText().toString();

        Intent intent = new Intent();
        intent.setAction(Constants.ACTION.ACTION_OTHER_APP);
        intent.putExtra(Constants.KEYS.DATA_MAIN, data);

        sendBroadcast(intent, "com.example.myPermission");

//        for limiting the scope of the broadcast to be sent within the app
//        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);

    }
}
