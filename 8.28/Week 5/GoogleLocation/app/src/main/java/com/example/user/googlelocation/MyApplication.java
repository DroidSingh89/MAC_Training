package com.example.user.googlelocation;

import android.app.Application;
import android.util.Log;

/**
 * Created by singh on 9/28/17.
 */

public class MyApplication extends Application {
    private static final String TAG = "MyApplicationTag";

    @Override
    public void onCreate() {
        super.onCreate();

        Log.d(TAG, "onCreate: ");
    }
}
