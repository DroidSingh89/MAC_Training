package com.example.user.androidnetworking;

import android.app.Application;
import android.content.Context;
import android.util.Log;

public class RandomApplication extends Application {


    private static final String TAG = RandomApplication.class.getSimpleName()+ "_TAG";
    @Override
    public void onCreate() {
        super.onCreate();

        Log.d(TAG, "onCreate: ");
    }

    public static RandomApplication get(Context context) {
        return (RandomApplication) context.getApplicationContext();
    }


    public String getString() {
        return "SomeString";
    }

}
