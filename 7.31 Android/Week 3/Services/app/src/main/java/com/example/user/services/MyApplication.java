package com.example.user.services;

import android.app.Application;
import android.util.Log;

/**
 * Created by singh on 8/14/17.
 */

public class MyApplication extends Application{


    @Override
    public void onCreate() {
        super.onCreate();

        Log.d("TAG", "onCreate: ");

    }
}
