package com.example.user.broadcastreceivers;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    MyDynamicReceiver myDynamicReceiver = new MyDynamicReceiver();
    IntentFilter intentFilter = new IntentFilter();
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.etDataForReceiver);

    }

    @Override
    protected void onStart() {
        super.onStart();
        intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        intentFilter.addAction("myAction");
        registerReceiver(myDynamicReceiver, intentFilter);

    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(myDynamicReceiver);

    }

    public void sendBroadcast(View view) {
        switch (view.getId()){
            case R.id.btnSendBroadcast:
                Intent intent = new Intent();
                intent.setAction("myAction");
                intent.putExtra("data", editText.getText().toString());
                sendBroadcast(intent);
                break;

            case R.id.btnSendBroadcastToOtherApp:
                Intent intent1 = new Intent();
                intent1.setAction("myActionForOtherApp");
                intent1.putExtra("data", editText.getText().toString());
                LocalBroadcastManager.getInstance(this).sendBroadcast(intent1);
                break;
        }


    }
}
