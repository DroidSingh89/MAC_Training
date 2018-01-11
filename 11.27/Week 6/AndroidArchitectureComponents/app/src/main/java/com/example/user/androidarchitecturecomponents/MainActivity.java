package com.example.user.androidarchitecturecomponents;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Chronometer;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Chronometer chronometer;
    private TextView tvLiveDataTimer;
    private ChronometerViewModel chronometerViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();



        setupChronoMeterViewModel();
        chronometer.start();


        LiveDataTimerViewModel liveDataTimerViewModel =
                ViewModelProviders.of(this).get(LiveDataTimerViewModel.class);

        Observer<Long> elapsedTimeObserver = new Observer<Long>() {
            @Override
            public void onChanged(@Nullable Long aLong) {
                String newTime = aLong + "Seconds elapsed";
                tvLiveDataTimer.setText(newTime);

            }
        };

        liveDataTimerViewModel.getElapsedTime().observe(this, elapsedTimeObserver);

    }

    private void setupChronoMeterViewModel() {
        chronometerViewModel = ViewModelProviders.of(this).get(ChronometerViewModel.class);

        if (chronometerViewModel.getStartTime() == null) {
//            if the start time if not defined
            long startTime = SystemClock.elapsedRealtime();
            chronometerViewModel.setStartTime(startTime);
            chronometer.setBase(startTime);
        } else {
//            else use the saved start time
            chronometer.setBase(chronometerViewModel.getStartTime());

        }
    }

    private void bindViews() {
        chronometer = findViewById(R.id.myChronometer);
        tvLiveDataTimer = findViewById(R.id.tvLiveDataTimer);
    }
}
