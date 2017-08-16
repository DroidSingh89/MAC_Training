package com.example.user.services.services;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

/**
 * Created by singh on 8/15/17.
 */

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class MyJobService extends JobService {



    @Override
    public boolean onStartJob(JobParameters jobParameters) {

        Log.d("TAG", "onStartJob: ");
        Intent intent = new Intent(getApplicationContext(), MyScheduleService.class);
        getApplicationContext().startService(intent);

        return false;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
