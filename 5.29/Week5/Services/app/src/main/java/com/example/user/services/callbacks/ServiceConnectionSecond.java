package com.example.user.services.callbacks;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

public class ServiceConnectionSecond implements ServiceConnection{
    @Override
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {


    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {

    }
}
