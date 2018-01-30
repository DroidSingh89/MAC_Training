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
import com.example.user.services.services.MyNormalService;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private MyBoundService myBoundService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void handlingServices(View view) {
        Log.d(TAG, "handlingServices: ");

//        intent for normal service
        Intent intentNormal =
                new Intent(getApplicationContext(), MyNormalService.class);


//        intent for intent service
        Intent intentInt =
                new Intent(getApplicationContext(), MyIntentService.class);

//        intent for bound service
        Intent intentBound =
                new Intent(getApplicationContext(), MyBoundService.class);

        switch (view.getId()) {

            case R.id.startNormal:
                intentNormal.putExtra("data", "Main data");
                startService(intentNormal);
                break;
            case R.id.stopNormal:
                stopService(intentNormal);
                break;

            case R.id.startIntentService:
            intentNormal.putExtra("data", "Main data");
            startService(intentInt);
            break;

            case R.id.bindService:
                bindService(intentBound, serviceConnection, Context.BIND_AUTO_CREATE);
                break;

            case R.id.unbindService:

                break;

        }

    }


    //create a service connection
    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyBoundService.MyBinder myBinder = (MyBoundService.MyBinder) service;
            myBoundService = myBinder.getService();
            myBoundService.init();
            Log.d(TAG, "onServiceConnected: " + myBoundService.getData());

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
}
