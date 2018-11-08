package com.example.user.services.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class MyBoundService extends Service {

    String boundData = "Default data";
    boolean isCounting = false;

    public MyBoundService() {
    }

    public IBinder iBinder = new MyBinder();

    //    create the binder to return the service instance
    public class MyBinder extends Binder {

        public MyBoundService getService() {
            return MyBoundService.this;
        }

    }


    @Override
    public IBinder onBind(Intent intent) {
        return iBinder;
    }

    //    methods to update the bound data
    public void updateData(String boundData) {
        this.boundData = boundData;
    }

    public String getBoundData() {
        return boundData;
    }

    public void startCounter(){

        isCounting = true;


        new Thread(new Runnable() {
            @Override
            public void run() {


                int counter = 1;
                while (isCounting) {

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                    //send broadcacst
                    Intent intent = new Intent("COUNTER");
                    intent.putExtra("COUNTER", counter);
                    sendBroadcast(intent);


                    counter++;


                }
            }
        }).start();

    }

    public void stopCounter() {
        isCounting = false;
    }


}
