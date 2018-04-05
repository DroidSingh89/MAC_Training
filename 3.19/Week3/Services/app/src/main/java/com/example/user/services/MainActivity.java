package com.example.user.services;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.user.services.services.MyBoundService;
import com.example.user.services.services.MyIntentService;
import com.example.user.services.services.MyStartedService;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private Intent intent;
    private MyBoundService myBoundService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent();
    }

    public void handlingServices(View view) {

//        way 1
        ComponentName normalComponent=
                new ComponentName(getApplicationContext(),
                        MyStartedService.class);

        ComponentName intentComponent=
                new ComponentName(getApplicationContext(),
                        MyIntentService.class);


//        way 2
        Intent intIntent = new Intent(getApplicationContext(), MyIntentService.class);

        switch (view.getId()) {
            case R.id.btnStartNormalService:

                intent.setComponent(normalComponent);
                startService(intent);

                break;
            case R.id.btnStopNormalService:

                intent.setComponent(normalComponent);
                stopService(intent);

                break;

            case R.id.btnStartIntentService:
//                intIntent.putExtra("data", "This is data from activity");
//                startService(intIntent);

                intent.setComponent(intentComponent);
                startService(intent);
                break;

            case R.id.btnBoundService:
                Intent boundIntent = new Intent(getApplicationContext(), MyBoundService.class);
                bindService(boundIntent, serviceConnection, Context.BIND_AUTO_CREATE);
                break;

            case R.id.btnUnBindService:
                break;

        }
    }

    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.d(TAG, "onServiceConnected: ");
            MyBoundService.MyBinder myBinder = (MyBoundService.MyBinder) iBinder;
            myBoundService = myBinder.getService();

            myBoundService.initData();
            Log.d(TAG, "onServiceConnected: " + myBoundService.getStringList());
            Log.d(TAG, "onServiceConnected: " + myBoundService.add("New String"));
            Log.d(TAG, "onServiceConnected: " + myBoundService.getStringList());

        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };
}
