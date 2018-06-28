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

import com.example.user.services.services.MyBound2Service;
import com.example.user.services.services.MyBoundService;
import com.example.user.services.services.MyIntentService;
import com.example.user.services.services.MyJobService;
import com.example.user.services.services.MyNormalService;

public class MainActivity extends AppCompatActivity implements ServiceConnection {

    MyBoundService myBoundService;
    MyBound2Service myBound2Service;
    boolean isBounded;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void handlingServices(View view) {

//        normal intent

        Intent normalIntent = new Intent(this, MyNormalService.class);
        normalIntent.putExtra("data", "some Data");

//        intentService intent
        Intent intIntent = new Intent(this, MyIntentService.class);
        intIntent.putExtra("iterations", 5);

//        boundIntent
        Intent boundIntent =
                new Intent(
                        this,
                        MyBoundService.class);


        Intent bound2Intent = new Intent(this, MyBound2Service.class);

        switch (view.getId()) {
//Normal Service
            case R.id.btnStartNormal:
                startService(normalIntent);

                break;

            case R.id.btnStopNormal:
                stopService(normalIntent);

                break;
//Intent Service
            case R.id.btnStartIntent:
                startService(intIntent);
                break;
//Bound service
            case R.id.btnBoundService:

                bindService(boundIntent,
                        this, Context.BIND_AUTO_CREATE);
                bindService(bound2Intent, this, Context.BIND_AUTO_CREATE);
                break;

            case R.id.btnGetData:


                if (isBounded) {
                    String data1 = myBoundService.getData();
                    String data2 = myBound2Service.getData();
                    Toast.makeText(this, data1, Toast.LENGTH_SHORT).show();
                    Toast.makeText(this, data2, Toast.LENGTH_SHORT).show();
                }


                break;

            case R.id.btnUnboundService:

                if (isBounded) {
                    unbindService(this);
                    isBounded = false;
                }

                break;

//Schedule service
            case R.id.btnScheduleService:


                JobScheduler jobScheduler = (JobScheduler)
                        getSystemService(Context.JOB_SCHEDULER_SERVICE);

                ComponentName componentName
                        = new ComponentName(this, MyJobService.class);

                JobInfo.Builder builder
                        = new JobInfo.Builder(0, componentName)
                        .setMinimumLatency(1000)
                        .setOverrideDeadline(1000);


                jobScheduler.schedule(builder.build());





                break;
        }
    }


    @Override
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {

        Log.d("TAG", "onServiceConnected: "+ componentName.getClassName());
        if (iBinder instanceof MyBoundService.MyBinder) {

            MyBoundService.MyBinder myBinder
                    = (MyBoundService.MyBinder) iBinder;
            myBoundService = myBinder.getService();
            isBounded = true;
        }

        if (iBinder instanceof MyBound2Service.MyBinder) {
            MyBound2Service.MyBinder myBinder
                    = (MyBound2Service.MyBinder) iBinder;
            myBound2Service = myBinder.getService();
            isBounded = true;
        }
    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {
        Log.d("TAG", "onServiceDisconnected: ");
        isBounded = false;
    }

    @Override
    public void onBindingDied(ComponentName name) {
        Log.d("TAG", "onBindingDied: "+ name.getClassName());
        isBounded = false;

    }
}
