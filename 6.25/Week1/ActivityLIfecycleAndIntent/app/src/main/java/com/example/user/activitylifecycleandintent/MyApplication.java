package com.example.user.activitylifecycleandintent;

import android.app.Application;
import android.util.Log;

public class MyApplication extends Application {


    private static final String TAG = MyApplication.class.getSimpleName();


    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        Log.d(TAG, "onTerminate: ");

    }
}
