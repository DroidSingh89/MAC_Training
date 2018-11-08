package com.example.user.services;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.services.services.MyBoundService;
import com.example.user.services.services.MyIntentService;
import com.example.user.services.services.MyJobService;
import com.example.user.services.services.MyNormalService;

public class MainActivity extends AppCompatActivity implements ServiceConnection {

    private static final String TAG = MainActivity.class.getSimpleName() + "_TAG";

    private EditText etBoundData;
    private TextView tvBoundData;
    private MyBoundService myBoundService;
    private boolean isBound;
    private MyCounterReceiver myCounterReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etBoundData = findViewById(R.id.etBoundData);
        tvBoundData = findViewById(R.id.tvBoundData);
    }

    public void onNormalService(View view) {

        Intent intent = new Intent(getApplicationContext(), MyNormalService.class);

        switch (view.getId()) {

            case R.id.btnStartNormal:
                startService(intent);

                break;

            case R.id.btnStopNormal:
                stopService(intent);

                break;
        }
    }

    public void onIntentService(View view) {

        switch (view.getId()) {

            case R.id.btnStartFoo:

                MyIntentService.startActionFoo(getApplicationContext(), "one", "two");

                break;
            case R.id.btnStartBaz:

                MyIntentService.startActionBaz(getApplicationContext(), "three", "four");

                break;
        }
    }

    public void onBoundService(View view) {

        Intent intent = new Intent(getApplicationContext(), MyBoundService.class);


        switch (view.getId()) {

            case R.id.btnBindService:

                if (!isBound)
                    bindService(intent, this, Context.BIND_AUTO_CREATE);


                break;

            case R.id.btnUnbindService:

                if (isBound) {

                    unbindService(this);
                    isBound = false;
                    myBoundService = null;
                    Toast.makeText(getApplicationContext(), "UnBind", Toast.LENGTH_SHORT).show();
                }


                break;

            case R.id.btnGetData:

                if (isBound)
                    tvBoundData.setText(myBoundService.getBoundData());


                break;
            case R.id.btnUpdateData:

                if (isBound)
                    myBoundService.updateData(etBoundData.getText().toString());

                break;


        }
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {

        MyBoundService.MyBinder myBinder = (MyBoundService.MyBinder) service;
        myBoundService = myBinder.getService();
        isBound = true;
        Toast.makeText(myBoundService, "Bounded", Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        isBound = false;
    }

    public void onScheduleService(View view) {

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            JobScheduler jobScheduler = (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);
            ComponentName componentName = new ComponentName(getApplicationContext(), MyJobService.class);
            JobInfo jobInfo = new JobInfo.Builder(0, componentName)
                    .setMinimumLatency(1000)
                    .setRequiresCharging(true)
                    .build();

            jobScheduler.schedule(jobInfo);

        }
    }

    public void onStopCounter(View view) {

        if (isBound) myBoundService.stopCounter();
    }

    public void onStartCounter(View view) {

        if (isBound) myBoundService.startCounter();

    }

    @Override
    protected void onStart() {
        super.onStart();
        myCounterReceiver = new MyCounterReceiver();
        IntentFilter intentFilter = new IntentFilter("COUNTER");
        registerReceiver(myCounterReceiver, intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(myCounterReceiver);

    }

    public class MyCounterReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {

            int counter = intent.getIntExtra("COUNTER", 0);
            tvBoundData.setText(String.valueOf(counter));

        }
    }
}
