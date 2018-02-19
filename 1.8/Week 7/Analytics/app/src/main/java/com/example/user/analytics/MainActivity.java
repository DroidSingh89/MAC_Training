package com.example.user.analytics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.mixpanel.android.mpmetrics.MixpanelAPI;

import org.json.JSONException;

public class MainActivity extends AppCompatActivity {


    AnalyticsManager analyticsManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        analyticsManager = new AnalyticsManager(this);

    }

    public void onJump(View view) throws JSONException {
        analyticsManager.track(Activity.JUMP);
    }

    public void onSkydive(View view) throws JSONException {
        analyticsManager.track(Activity.SKYDIVE);
    }

    public void onSwim(View view) throws JSONException {
        analyticsManager.track(Activity.SWIM);
    }

    public void onRun(View view) throws JSONException {
        analyticsManager.track(Activity.RUN);
    }

    public void onStartTimer(View view) {
        analyticsManager.timeEvent(Activity.TIMER);
    }

    public void onStopTimer(View view) throws JSONException {
        analyticsManager.track(Activity.TIMER);
    }



}
