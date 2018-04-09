package com.example.user.broadcastreceivers;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.user.broadcastreceivers.receivers.MyCustomReceiver;
import com.example.user.broadcastreceivers.receivers.MyStaticReceiver;

public class MainActivity extends AppCompatActivity {

    private MyStaticReceiver myStaticReceiver;
    private MyCustomReceiver myCustomReceiver;
    private EditText etMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etMain = findViewById(R.id.etMain);

    }

    @Override
    protected void onStart() {
        super.onStart();
        //register myStaticReceiver
        myStaticReceiver = new MyStaticReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        registerReceiver(myStaticReceiver, intentFilter);

        //register myCustomReceiver
        myCustomReceiver = new MyCustomReceiver();
        IntentFilter intentFilterCustom = new IntentFilter();
        intentFilterCustom.addAction("myAction");
        intentFilterCustom.addAction("myIntentAction");
        registerReceiver(myCustomReceiver, intentFilterCustom);

    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(myStaticReceiver);
        unregisterReceiver(myCustomReceiver);

    }

    public void sendBroadcast(View view) {

        Intent intent = new Intent();
        intent.setAction("myAction");
        intent.putExtra("data", etMain.getText().toString());
        sendBroadcast(intent);

    }

    public void startService(View view) {
        startService(new Intent(getApplicationContext(), MyIntentService.class));
    }
}
