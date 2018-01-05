package com.example.user.services.services.bound;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyBoundService extends Service {

    private static final String TAG = "MyBoundTag";
    private List<Integer> integers;
    IBinder binder = new MyBinder();

    public MyBoundService() {
    }


    //pass this class reference to the bound component
    public class MyBinder extends Binder {
        public MyBoundService getService() {
            return MyBoundService.this;
        }
    }


    //create sample data to be received by the client
    public void initData(int size) {
        Log.d(TAG, "initData: ");
        integers.clear();

        for (int i = 0; i < size; i++) {
            integers.add(new Random().nextInt(100));
        }
    }

    public List<Integer> getIntegerData() {
        Log.d(TAG, "getIntegerData: ");
        return integers;
    }

    public void addInteger(int integer){
        Log.d(TAG, "addInteger: ");
        integers.add(integer);
    }


    @Override
    public void onCreate() {
        super.onCreate();
        integers = new ArrayList<>();
        Log.d(TAG, "onCreate: ");
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind: ");
        return binder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "onUnbind: ");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy: ");
        super.onDestroy();
    }

}
