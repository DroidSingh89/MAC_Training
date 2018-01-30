package com.example.user.services;

import android.app.Application;
import android.util.Log;

/**
 * Created by singh on 1/30/18.
 */

public class MyApplication extends Application {

    private static final String TAG = MyApplication.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
    }
}
