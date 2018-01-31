package com.example.user.broadcastreceivers;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.user.broadcastreceivers.receivers.MyReceiverTwo;

public class MainActivity extends AppCompatActivity {

    private MyReceiverTwo myReceiverTwo;
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

        myReceiverTwo = new MyReceiverTwo();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        intentFilter.addAction("myAction");
        registerReceiver(myReceiverTwo, intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(myReceiverTwo);
    }

    public void onSendingBroadcast(View view) {

        Intent intent = new Intent(getApplicationContext(), MyIntentService.class);
        intent.putExtra("data", editText.getText().toString());
        startService(intent);
    }

    public void onSendingBroadcastOutside(View view) {
        Intent intent = new Intent("myActionOutside");
        intent.putExtra("data", editText.getText().toString());
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }
}
