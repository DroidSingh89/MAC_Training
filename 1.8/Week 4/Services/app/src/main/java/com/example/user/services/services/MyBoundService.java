package com.example.user.services.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

/*
df
s
sdf
sdf
f
sd
sdf



*/


public class MyBoundService extends Service {

    private String data;

    public MyBoundService() {
    }

    IBinder iBinder = new MyBinder();

    public class MyBinder extends Binder{

        public MyBoundService getService(){
            return MyBoundService.this;
        }


    }

    @Override
    public IBinder onBind(Intent intent) {
        return iBinder;
    }

    //init data
    public void init() {
        data = "Some data";
    }

    public String getData() {
        return data;
    }
}
