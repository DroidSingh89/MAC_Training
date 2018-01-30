package com.example.user.services.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.example.user.services.data.LocalDataSource;

import java.util.List;

public class MyBoundService extends Service {

    private String data;
    private List<String> stringList;

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
        stringList = LocalDataSource.getSimpleData(10);
    }

    public List<String> getData() {
        return stringList;
    }

    public void addToData(String name) {

        stringList.add(name);

    }
}
