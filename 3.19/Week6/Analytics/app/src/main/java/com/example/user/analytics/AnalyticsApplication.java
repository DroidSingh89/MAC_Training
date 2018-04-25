package com.example.user.analytics;

import android.app.Application;
import android.util.Log;

public class AnalyticsApplication extends Application {


    private static final String TAG = AnalyticsApplication.class.getSimpleName() + "_TAG";


    @Override
    public void onCreate() {
        super.onCreate();

        Log.d(TAG, "onCreate: ");
    }
}
