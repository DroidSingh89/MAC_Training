package com.example.user.services.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.FileNotFoundException;

import static android.content.ContentValues.TAG;

public class MyScheduledService extends Service {
    public MyScheduledService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: This is the scheduled service");
        return super.onStartCommand(intent, flags, startId);
    }
}
