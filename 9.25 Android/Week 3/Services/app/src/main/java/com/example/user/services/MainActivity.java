package com.example.user.services;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.user.services.model.Car;
import com.example.user.services.services.MyBoundService;
import com.example.user.services.services.MyIntentService;
import com.example.user.services.services.MyJobService;
import com.example.user.services.services.MyStartedService;

import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTag";

    MyBoundService myBoundService;
    boolean isBound;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void startServices(View view) {

        Intent normalIntent = new Intent(this, MyStartedService.class);
        Intent intIntent = new Intent(this, MyIntentService.class);
        Intent boundIntent = new Intent(this, MyBoundService.class);


        switch (view.getId()) {

            case R.id.btnStartedService:
                normalIntent.putExtra("data", "This is a normal started service");
                startService(normalIntent);
                break;
            case R.id.btnStopService:
                stopService(normalIntent);
                break;
            case R.id.btnStartIntentService:
                intIntent.putExtra("data", "This is an Intent service");
                intIntent.setAction("Task1");
                startService(intIntent);
                break;

            case R.id.btnStartIntentServiceTask2:
                intIntent.putExtra("data", "This is an Intent service");
                intIntent.setAction("Task2");
                startService(intIntent);
                break;

            case R.id.btnBoundService:

                bindService(boundIntent, serviceConnection, Context.BIND_AUTO_CREATE);

                break;


            case R.id.btnBoundGetCars:

                if (isBound) {
                    List<Car> carList = myBoundService.getCars();
                    for (Car car : carList) {
                        Log.d(TAG, "startServices: "
                                + "Model:" + car.getModel()
                                + "Year: " + car.getYear());
                    }
                }

                break;

            case R.id.btnAddCar:

                if (isBound) {
                    int year = new Random().nextInt(50);
                    year = year + 1950;
                    Car car = new Car("Sedan", "Dodge", "Charger", year, "Black");
                    boolean isCarAdded = myBoundService.addCar(car);
                    if (isCarAdded) {
                        Toast.makeText(myBoundService, "Car added", Toast.LENGTH_SHORT).show();
                    }
                }

                break;
            case R.id.btnUnBindService:

                if (isBound) {
                    unbindService(serviceConnection);
                    isBound = false;
                }

                break;

            case R.id.btnScheduleJob:
                //create the component that has the job
                ComponentName componentName = new ComponentName(this, MyJobService.class);
                //create jobInfo for setting job parameters
                JobInfo jobInfo = new JobInfo.Builder(0, componentName)
                        .setMinimumLatency(1000)
                        .setOverrideDeadline(5000)
                        .build();

                JobScheduler jobScheduler = getSystemService(JobScheduler.class);
                jobScheduler.schedule(jobInfo);


                break;


        }

    }

    //create the service connection to bind to the service
    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.d(TAG, "onServiceConnected: ");
            MyBoundService.MyBinder myBinder = (MyBoundService.MyBinder) iBinder;
            myBoundService = myBinder.getService();

            isBound = true;

            myBoundService.initData();


        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

            Log.d(TAG, "onServiceDisconnected: ");
            isBound = false;
        }
    };


}
