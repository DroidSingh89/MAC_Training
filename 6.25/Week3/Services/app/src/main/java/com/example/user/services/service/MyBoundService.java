package com.example.user.services.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyBoundService extends Service {
    private static final String TAG = MyBoundService.class.getSimpleName() + "_TAG";


    public MyBoundService() {
    }


    IBinder iBinder = new MyBinder();

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


    public String getDataFromServer() {
        return "This is the data from server";
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "onUnbind: ");
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        Log.d(TAG, "onRebind: ");
        super.onRebind(intent);
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy: ");
        super.onDestroy();
    }

    //    Binder class to communicate with clients
    public class MyBinder extends Binder {

        public MyBoundService getService() {
            return MyBoundService.this;
        }
    }
}
