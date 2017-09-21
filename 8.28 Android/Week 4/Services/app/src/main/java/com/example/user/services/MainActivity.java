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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTag";
    MyBoundService myBoundService;
    List<String> dummyData = new ArrayList<>();
    private boolean isBoundConnected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void startServices(View view) {

        String data = "someData";


        //create a normal intent to start the service
        Intent normalIntent = new Intent(this, MyService.class);

        //create a intent to start intent service
        Intent intIntent = new Intent(this, MyIntentService.class);

        //create an intent for the bound service
        Intent boundIntent = new Intent(this, MyBoundService.class);

        switch (view.getId()) {

            case R.id.btnNormalServiceStart:
                normalIntent.putExtra("data", data);
                startService(normalIntent);
                break;

            case R.id.btnNormalServiceStop:
                stopService(normalIntent);
                break;


            case R.id.btnIntentserviceStart:
                intIntent.putExtra("data", "This is an intent service");
                startService(intIntent);
                break;

            case R.id.btnBoundToService:
                boundIntent.putExtra("data", "This is a bound service");
                bindService(boundIntent, serviceConnection, Context.BIND_AUTO_CREATE);
                break;


            case R.id.btnBoundInitData:

                if (isBoundConnected) {
                    myBoundService.initData(5);
                    Toast.makeText(this, "Data initialized", Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.btnBoundGetData:
                if (isBoundConnected) {
                    dummyData = myBoundService.getDummyData();
                    for (int i = 0; i < dummyData.size(); i++) {
                        Toast.makeText(myBoundService, dummyData.get(i), Toast.LENGTH_SHORT).show();
                    }
                }
                break;

            case R.id.btnUnboundToService:
                unbindService(serviceConnection);
                break;
        }

    }

    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.d(TAG, "onServiceConnected: ");

            MyBoundService.MyBinder myBinder = (MyBoundService.MyBinder) iBinder;
            myBoundService = myBinder.getService();
            isBoundConnected = true;
            Toast.makeText(myBoundService, "Service is bound", Toast.LENGTH_SHORT).show();


        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Log.d(TAG, "onServiceDisconnected: ");

            Toast.makeText(myBoundService, "Service disconnected", Toast.LENGTH_SHORT).show();
            isBoundConnected = false;
        }
    };

}



