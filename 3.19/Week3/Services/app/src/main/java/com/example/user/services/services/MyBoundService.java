package com.example.user.services.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.ArrayList;
import java.util.List;

public class MyBoundService extends Service {

    private List<String> stringList;
    //create the Ibinder instance
    IBinder iBinder = new MyBinder();


    public MyBoundService() {
    }
    public class MyBinder extends Binder {
        public MyBoundService getService() {
            return MyBoundService.this;
        }

    }

    @Override
    public IBinder onBind(Intent intent) {
        return iBinder;
    }

    //create random data
    public void initData() {
        stringList = new ArrayList<>();
        stringList.add("A");
        stringList.add("B");
        stringList.add("C");
        stringList.add("D");
        stringList.add("E");
        stringList.add("F");

    }

    public List<String> getStringList() {
        return stringList;
    }

    public boolean add(String string) {
        return stringList.add(string);
    }

}
