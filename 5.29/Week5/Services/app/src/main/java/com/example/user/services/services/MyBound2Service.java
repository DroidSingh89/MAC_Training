package com.example.user.services.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import static android.content.ContentValues.TAG;

public class MyBound2Service extends Service {
    public MyBound2Service() {
    }

    IBinder iBinder = new MyBound2Service.MyBinder(this);


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
        return "This is the data from bound service3424";
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

        MyBound2Service myBound2Service;

        public MyBinder(MyBound2Service myBound2Service) {
            this.myBound2Service = myBound2Service;
        }

        public MyBound2Service getService() {
            return myBound2Service;
        }


    }
}
