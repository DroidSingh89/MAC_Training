package com.example.user.services.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    private static final String TAG = MyService.class.getSimpleName() + "_TAG";


    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: "+ intent.getStringExtra("data"));

        Log.d(TAG, "onStartCommand: Thread:"+ Thread.currentThread().getName());

//        perform a task
        Log.d(TAG, "onStartCommand: Performing a task");

//        stop service after task complete
        Log.d(TAG, "onStartCommand: Task complete");
        stopSelf();


        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy: ");
        super.onDestroy();
    }
}
