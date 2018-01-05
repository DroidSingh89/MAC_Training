package com.example.user.services.services.scheduled;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

/**
 * Created by singh on 12/13/17.
 */

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class MyJobService extends JobService{


    private static final String TAG = "MyJobTag";

    @Override
    public boolean onStartJob(JobParameters params) {

        Log.d(TAG, "onStartJob: ");
        Intent intent = new Intent(getApplicationContext(), MyScheduleService.class);
        intent.putExtra("data", params.getExtras().getString("sample_data_key"));
        getApplicationContext().startService(intent);

        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        Log.d(TAG, "onStopJob: ");
        return false;
    }
}
