package com.example.user.services.service;

import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.RequiresApi;
import android.util.Log;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class MyJobService extends JobService {

    private static final String TAG = MyJobService.class.getSimpleName() + "_TAG";


    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public boolean onStartJob(JobParameters jobParameters) {


        Log.d(TAG, "onStartJob: ");
//        schedule the job
        Intent intent = new Intent(getApplicationContext(), MyService.class);
        startService(intent);

        return false;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        Log.d(TAG, "onStopJob: ");
        return false;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }


}
