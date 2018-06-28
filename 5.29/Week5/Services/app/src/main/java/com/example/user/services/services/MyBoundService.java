package com.example.user.services.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import static android.content.ContentValues.TAG;

public class MyBoundService extends Service {

    public MyBoundService() {
    }

    IBinder iBinder = new MyBinder(this);


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

    public String getData() {
        return "This is the data from bound service";
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    public class MyBinder extends Binder {

        MyBoundService myBoundService;

        public MyBinder(MyBoundService myBoundService) {
            this.myBoundService = myBoundService;
        }

        public MyBoundService getService() {
            return myBoundService;
        }


    }
}
