package com.example.user.analytics;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.json.JSONException;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private AnalyticsManager analyticsManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        analyticsManager = new AnalyticsManager(this);
    }

    public void onJumping(View view) throws JSONException {

        String propValue = String.valueOf(new Random().nextInt(30));
        String propName = "Jumps";

        analyticsManager.track(AnalyticsManager.Event.JUMP, propName, propValue);
    }

    public void onSwimming(View view) throws JSONException {

        String propValue = String.valueOf((new Random().nextInt(10) * 10) + 100);
        String propName = "Distance(ft)";

        analyticsManager.track(AnalyticsManager.Event.SWIM, propName, propValue);
    }

    public void onRunning(View view) throws JSONException {

        String propValue = String.valueOf(new Random().nextInt(30) + 100);
        String propName = "Distance(meters)";

        analyticsManager.track(AnalyticsManager.Event.RUN, propName, propValue);
    }

    public void onSkydiving(View view) throws JSONException {

        String propValue = String.valueOf((new Random().nextInt(10) + 1000) * 1000);
        String propName = "Altitude(ft)";

        analyticsManager.track(AnalyticsManager.Event.SKYDIVE, propName, propValue);
    }
}
