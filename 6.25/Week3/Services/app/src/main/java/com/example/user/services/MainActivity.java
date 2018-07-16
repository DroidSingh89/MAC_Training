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
import android.view.View;
import android.widget.Toast;

import com.example.user.services.service.MyBoundService;
import com.example.user.services.service.MyIntentService;
import com.example.user.services.service.MyJobService;
import com.example.user.services.service.MyNewProcessService;
import com.example.user.services.service.MyService;

import java.util.ServiceConfigurationError;

public class MainActivity extends AppCompatActivity {


    private static final int JOB_ID_NORMAL_SERVICE = 10;


    MyBoundService boundService;
    boolean isBound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onStartedServices(View view) {

//service intent
        Intent serviceIntent = new Intent(getApplicationContext(), MyService.class);
        serviceIntent.putExtra("data", "Data from main activity");
//intentService intent
        Intent intIntent = new Intent(getApplicationContext(), MyIntentService.class);



        switch (view.getId()) {

            case R.id.btnStartService:

                startService(serviceIntent);

                break;

            case R.id.btnStopService:

                stopService(serviceIntent);

                break;

            case R.id.btnStartIntent:

                startService(intIntent);
                break;
        }

    }

    public void onBoundServices(View view) {

        Intent boundIntent = new Intent(getApplicationContext(), MyBoundService.class);

        switch (view.getId()) {

            case R.id.btnBoundService:

                if (!isBound) {
                    bindService(boundIntent, serviceConnection, Context.BIND_AUTO_CREATE);
                    isBound = true;
                }

                break;

            case R.id.btnGetData:
                if (isBound) {
                    String data = boundService.getDataFromServer();
                    Toast.makeText(MainActivity.this, data, Toast.LENGTH_SHORT).show();

                }

                break;

            case R.id.btnUnBind:
                if (isBound) {
                    unbindService(serviceConnection);
                    isBound = false;
                }

                break;
        }
    }

    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MyBoundService.MyBinder myBinder = (MyBoundService.MyBinder) iBinder;
            boundService = myBinder.getService();
            isBound = true;


        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            isBound = false;

        }

    };


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void onScheduleJob(View view) {


        ComponentName componentName = new ComponentName(getApplicationContext(), MyJobService.class);
        JobInfo.Builder builder = new JobInfo.Builder(JOB_ID_NORMAL_SERVICE, componentName)
                .setRequiresDeviceIdle(true)
                .setOverrideDeadline(5000);

        JobScheduler jobScheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);

        jobScheduler.schedule(builder.build());




    }

    public void onServiceOnNewProcess(View view) {
        Intent intent = new Intent(getApplicationContext(), MyNewProcessService.class);
        startService(intent);
    }
}
