package com.example.user.services.services;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class MyJobService extends JobService {

    @Override
    public boolean onStartJob(JobParameters params) {

        Intent intent = new Intent(getApplicationContext(), MyIntentService.class);
        startService(intent);
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }
}
