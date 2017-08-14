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


    private static final String TAG = "MainActivityTag";
    MyBoundService myBoundService;
    Boolean isBound = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("TAG", "onCreate: act");
    }

    public void startServices(View view) {

        Intent normalIntent = new Intent(this, MyNormalService.class);
        Intent intIntent = new Intent(this, MyIntentService.class);
        Intent boundIntent = new Intent(this, MyBoundService.class);


        switch (view.getId()){

            case R.id.btnStartNormalService:

                normalIntent.putExtra("data","This is a normal service");
                startService(normalIntent);

                break;

            case R.id.btnStopNormalService:


                break;
            case R.id.btnStartIntentService:

                intIntent.putExtra("data"," This is an intent service repo");
                intIntent.setAction("getRepo");
                startService(intIntent);
                break;
            case R.id.btnBindService:

                bindService(boundIntent, serviceConnection, Context.BIND_AUTO_CREATE);

                break;

            case R.id.btnUnBindService:

                if(isBound) {
                    unbindService(serviceConnection);
                    isBound = false;
                }
                break;
        }
    }
    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MyBoundService.MyBinder myBinder = (MyBoundService.MyBinder) iBinder;
            myBoundService = myBinder.getService();
            Log.d(TAG, "onServiceConnected: " + myBoundService.getRandomData());
            isBound = true;

        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Log.d(TAG, "onServiceDisconnected: ");
            isBound = false;
        }
    };

}
