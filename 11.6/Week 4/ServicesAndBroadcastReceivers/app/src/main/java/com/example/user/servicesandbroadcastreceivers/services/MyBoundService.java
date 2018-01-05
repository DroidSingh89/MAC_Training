package com.example.user.servicesandbroadcastreceivers.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyBoundService extends Service {

    private static final String TAG = "MyBoundServiceTag";
    private String data;

    public MyBoundService() {
    }

    IBinder iBinder = new MyBinder();

    public class MyBinder extends Binder {
        public MyBoundService getService() {
            return MyBoundService.this;
        }
    }

    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate: ");
        super.onCreate();
    }

    @Override
    public IBinder onBind(Intent intent) {

        Log.d(TAG, "onBind: ");
        return iBinder;

    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "onUnbind: ") ;
        return super.onUnbind(intent);

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    public void initData() {
        data = "data from the server";

    }

    public String getData() {
        return data;
    }


}
