package com.example.user.services;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import android.os.PersistableBundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.user.services.services.bound.MyBoundService;
import com.example.user.services.services.scheduled.MyJobService;
import com.example.user.services.services.started.MyIntentService;
import com.example.user.services.services.started.MyStartedService;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String SAMPLE_DATA = "This is the data sent from main activity";
    private static final String SAMPLE_DATA_KEY = "sample_data_key";
    private static final String TAG = "MainActivityTag";
    private MyBoundService myBoundService;
    private boolean isBound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onStartedServices(View view) {

        Log.d(TAG, "onStartedServices: ");
//        create intents for the services
        Intent startedIntent = new Intent(this, MyStartedService.class);


        switch (view.getId()) {

            case R.id.btnStartNormal:

                startedIntent.putExtra(SAMPLE_DATA_KEY, SAMPLE_DATA + String.valueOf(new Random().nextInt(100)));
                startService(startedIntent);

                break;

            case R.id.btnStopNormal:

                stopService(startedIntent);

                break;

            case R.id.btnStartIntent:

                //MyIntentService.startActionFoo(this, "First", "Second");

                Intent intent = new Intent(this, MyIntentService.class);
                startService(intent);


                break;
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void onScheduledServices(View view) {

        Log.d(TAG, "onScheduledServices: ");

        PersistableBundle bundle = new PersistableBundle();
        bundle.putString(SAMPLE_DATA_KEY, SAMPLE_DATA);
        ComponentName componentName = new ComponentName(this, MyJobService.class);

        JobInfo jobInfo = new JobInfo.Builder(0, componentName)
                .setMinimumLatency(1000)
                .setExtras(bundle)
                .build();

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            JobScheduler jobScheduler = getSystemService(JobScheduler.class);
            jobScheduler.schedule(jobInfo);
        }


    }

    public void onBoundServices(View view) {

        Intent bindIntent = new Intent(this, MyBoundService.class);
        switch (view.getId()) {
            case R.id.btnBind:

                bindService(bindIntent, serviceConnection, Context.BIND_AUTO_CREATE);
                break;

            case R.id.btnInitData:
                if (isBound) myBoundService.initData(5);
                break;

            case R.id.btnGetData:

                if (isBound) {
                    for (Integer integer : myBoundService.getIntegerData()) {
                        Log.d(TAG, "onBoundServices: data:" + integer);
                    }
                }

                break;

            case R.id.btnAddData:
                if (isBound)
                    myBoundService.addInteger(500);
                break;

            case R.id.btnUnBind:
                unbindService(serviceConnection);
                isBound = false;
                break;
        }

    }

    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

            Log.d(TAG, "onServiceConnected: ");
            MyBoundService.MyBinder myBinder = (MyBoundService.MyBinder) service;
            myBoundService = myBinder.getService();

            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d(TAG, "onServiceDisconnected: ");
            isBound = false;

        }
    };


}
