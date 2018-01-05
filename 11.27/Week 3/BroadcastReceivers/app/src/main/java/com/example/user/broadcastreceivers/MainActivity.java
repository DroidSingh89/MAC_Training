package com.example.user.broadcastreceivers;

import android.Manifest;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.broadcastreceivers.receivers.MyDynamicReceiver;

public class MainActivity extends AppCompatActivity
        implements MyDynamicReceiver.OnReceiverInteraction {

    private static final String TAG = "MainActivityTag";
    private MyDynamicReceiver myDynamicReceiver;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.etData);

    }


    @Override
    protected void onStart() {
        super.onStart();
        myDynamicReceiver = new MyDynamicReceiver();


        IntentFilter intentFilter = new IntentFilter("myaction");
        intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        registerReceiver(myDynamicReceiver, intentFilter);

    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(myDynamicReceiver);
    }

    public void sendBroadcast(View view) {

        Intent intent = new Intent("myaction");
        sendBroadcast(intent, Manifest.permission.BLUETOOTH);
    }

    public void sendBroadcastOutside(View view) {

        Intent intent = new Intent("actionOutside");
        intent.putExtra("data", editText.getText().toString());

        //send the broadcast externally
        sendBroadcast(intent, "com.permission.myCustomPermission");
        //using the local manager you would restrict the broadcast to be sent externally
        //LocalBroadcastManager.getInstance(this).sendBroadcast(intent);

    }

    @Override
    public void onBroadcastReceived(Intent intent) {

        Toast.makeText(this, "Triggered", Toast.LENGTH_SHORT).show();

        Log.d(TAG, "onBroadcastReceived: ");

    }
}
