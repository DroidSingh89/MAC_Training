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
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.services.services.MyBoundService;
import com.example.user.services.services.MyIntentService;
import com.example.user.services.services.MyJobService;
import com.example.user.services.services.MyNormalService;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private MyBoundService myBoundService;
    private boolean isBound;
    private EditText etStringName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");

        etStringName = findViewById(R.id.etStringName);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void handlingServices(View view) {
        Log.d(TAG, "handlingServices: ");

//        intent for normal service
        Intent intentNormal =
                new Intent(getApplicationContext(), MyNormalService.class);


//        intent for intent service
        Intent intentInt =
                new Intent(getApplicationContext(), MyIntentService.class);

//        intent for bound service
        Intent intentBound =
                new Intent(getApplicationContext(), MyBoundService.class);

        switch (view.getId()) {

            case R.id.startNormal:
                intentNormal.putExtra("data", "Main data");
                startService(intentNormal);
                break;
            case R.id.stopNormal:
                stopService(intentNormal);
                break;

            case R.id.startIntentService:
                intentNormal.putExtra("data", "Main data");
                startService(intentInt);
                break;

            case R.id.bindService:
                bindService(intentBound, serviceConnection, Context.BIND_AUTO_CREATE);
                break;

            case R.id.unbindService:
                if (isBound) {
                    unbindService(serviceConnection);
                    isBound = false;
                }

                break;

            case R.id.btnScheduleService:

                ComponentName componentName = new ComponentName(this, MyJobService.class);
                JobInfo jobInfo = new JobInfo.Builder(0, componentName)
                        .setMinimumLatency(1000)
                        .build();

                JobScheduler jobScheduler = (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);
                jobScheduler.schedule(jobInfo);

                break;

        }

    }

    //create a service connection
    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyBoundService.MyBinder myBinder = (MyBoundService.MyBinder) service;
            myBoundService = myBinder.getService();
            myBoundService.init();

            isBound = true;
            Log.d(TAG, "onServiceConnected: " + myBoundService.getData());
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

            isBound = false;
        }
    };

    public void onAddToList(View view) {

        if (isBound) {
            myBoundService.addToData(etStringName.getText().toString());
            Toast.makeText(myBoundService, "Added", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(myBoundService, "Service not bound", Toast.LENGTH_SHORT).show();
        }


    }

    public void onListReceived(View view) {

        if (isBound) {
            for (String s : myBoundService.getData()) {
                Log.d(TAG, "onListReceived: " + s);
            }
        }
    }

    public void onSecondActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
        startActivity(intent);
    }
}
