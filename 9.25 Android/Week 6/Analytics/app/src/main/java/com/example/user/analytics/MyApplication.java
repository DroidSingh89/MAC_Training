package com.example.user.analytics;

import android.app.Application;
import android.util.Log;

/**
 * Created by singh on 10/31/17.
 */

public class MyApplication extends Application {

    private static final String TAG = "MyAppTag";

    @Override
    public void onCreate() {
        super.onCreate();

        Log.d(TAG, "onCreate: ");
    }
}
