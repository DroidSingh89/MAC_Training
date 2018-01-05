package com.example.user.services.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import com.example.user.services.model.Car;

import java.util.ArrayList;
import java.util.List;

public class MyBoundService extends Service {


    private static final String TAG = "MyBoundService";
    List<Car> cars;
    IBinder iBinder = new MyBinder();

    public MyBoundService() {
    }

    //using the binder
    public class MyBinder extends Binder {

        public MyBoundService getService() {
            return MyBoundService.this;

        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
    }

    @Override
    public IBinder onBind(Intent intent) {

        Log.d(TAG, "onBind: ");

        return iBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "onUnbind: ");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    public void initData() {
        cars = new ArrayList<>();
        cars.add(new Car("Sedan", "Dodge", "Challenger", 1987, "Black"));
        cars.add(new Car("Sedan", "BMW", "M6", 2017, "Red"));

    }

    public List<Car> getCars() {
        return cars;
    }

    public boolean addCar(Car car) {
        return cars.add(car);
    }

}
