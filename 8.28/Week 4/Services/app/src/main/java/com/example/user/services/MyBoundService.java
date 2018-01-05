package com.example.user.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyBoundService extends Service {
    private static final String TAG = "MyBoundServiceTag";
    IBinder iBinder = new MyBinder();
    List<String> dummyData = new ArrayList<>();

    public MyBoundService() {
    }


    public class MyBinder extends Binder {

        public MyBoundService getService() {

            return MyBoundService.this;
        }

    }

    @Override
    public void onCreate() {
        super.onCreate();

        Log.d(TAG, "onCreate: ");
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind: " + intent.getStringExtra("data"));

        return iBinder;
    }


    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy: ");
        super.onDestroy();

    }

    public void initData(int initializeStr) {
        //creating random numbers of list of size initializeStr
        for (int i = 0; i < initializeStr; i++) {
            dummyData.add(String.valueOf(new Random().nextInt(100)));
        }
    }

    public List<String> getDummyData() {
        return dummyData;
    }


}
