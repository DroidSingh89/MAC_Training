package com.example.user.services.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyNormalService extends Service {


    private static final String TAG = MyNormalService.class.getSimpleName() + "_TAG";

    public MyNormalService() {

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: " + Thread.currentThread().getName());
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: "
                + Thread.currentThread().getName() + " "
                + this.toString());

        //complete
//        stopSelf();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: " + Thread.currentThread().getName());

    }
}
