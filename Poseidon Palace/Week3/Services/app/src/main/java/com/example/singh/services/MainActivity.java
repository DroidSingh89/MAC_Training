package com.example.singh.services;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startService(View view) {

        Intent intent = new Intent(this, MyService.class);
        startService(intent);


    }


    public void stopService(View view){
        Intent intent = new Intent(this, MyService.class);
        stopService(intent);


    }


    public void startIntentService(View view) {

        Intent intent = new Intent(this, MyIntentService.class);
        startService(intent);
    }


    private static Intent alarmIntent = null;
    private static PendingIntent pendingIntent = null;
    private static AlarmManager alarmManager = null;

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void scheduleService(View view) {

        Calendar calendar = Calendar.getInstance();
        alarmIntent = new Intent ( this, MyScheduledService.class );
        pendingIntent = PendingIntent.getBroadcast( this.getApplicationContext(), 123, alarmIntent, 0 );
        alarmManager = ( AlarmManager ) getSystemService( ALARM_SERVICE );
        alarmManager.setRepeating( AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), 5000, pendingIntent );


    }
}
