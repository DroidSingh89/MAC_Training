package com.example.user.analytics;

import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import org.json.JSONException;

import java.util.Random;

public class MainActivity extends AppCompatActivity {



    private ImageView ivMain;
    private AnalyticsManager analyticsManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ivMain = findViewById(R.id.ivMain);

        analyticsManager = new AnalyticsManager(this);

    }

    public void onRunning(View view) throws JSONException {

        Event event = new Event(AnalyticsManager.Events.RUN,
                new Event.PropBuilder()
                        .addProp("speed", "5mph")
                        .build());

        analyticsManager.trackEvent(event);


    }

    public void onJumping(View view) throws JSONException {

        Event event = new Event(AnalyticsManager.Events.JUMP,
                new Event.PropBuilder()
                        .addProp("height", "5feet")
                        .build());

        analyticsManager.trackEvent(event);
    }

    public void onSkydive(View view) throws JSONException {

        Event event = new Event(AnalyticsManager.Events.SKYDIVE,
                new Event.PropBuilder()
                        .addProp("altitute", "18000ft")
                        .build());

        analyticsManager.trackEvent(event);
    }

    public void onSwimming(View view) throws JSONException {

        Event event = new Event(AnalyticsManager.Events.SWIM,
                new Event.PropBuilder()
                        .addProp("length", "100ft")
                        .build());

        analyticsManager.trackEvent(event);
    }

    public void onImageLoad(View view) {

        analyticsManager.timeEvent(new Event(AnalyticsManager.Events.LOAD_IMAGE, null));

        final Random random = new Random();
        final int maxTime = 3000;
        final int minTime = 1000;

        final int randomTime = random.nextInt(maxTime + 1 - minTime) + minTime;

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void run() {

                ivMain.setBackground(getDrawable(R.drawable.ic_launcher_background));

                Event event = null;
                try {
                    event = new Event(AnalyticsManager.Events.LOAD_IMAGE,
                            new Event.PropBuilder()
                                    .addProp("time", String.valueOf(randomTime))
                                    .build());
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                analyticsManager.trackEvent(event);

            }
        }, randomTime);


    }
}
