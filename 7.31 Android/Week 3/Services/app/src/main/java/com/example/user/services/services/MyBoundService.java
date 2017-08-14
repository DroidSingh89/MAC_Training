package com.example.user.services.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import java.util.Random;

public class MyBoundService extends Service {


    private static final String TAG = "MyBoundServiceTag";

    IBinder iBinder = new MyBinder();

    public MyBoundService() {
    }


    @Override
    public void onCreate() {
        super.onCreate();

        Log.d(TAG, "onCreate: ");

    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind: ");
        return iBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {

        Log.d(TAG, "onUnbind: ");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }


    public class MyBinder extends Binder {

        public MyBoundService getService(){
            return MyBoundService.this;
        }

    }

    public int getRandomData(){
        Random randomGenerator = new Random();
        return randomGenerator.nextInt(100);
    }
}
