package com.example.user.analytics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.mixpanel.android.mpmetrics.MixpanelAPI;

import org.json.JSONException;

public class MainActivity extends AppCompatActivity {

    private MixpanelAPI mixpanelAPI;
    private AnalyticsManager analyticsManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mixpanelAPI = MixpanelAPI
                .getInstance(this, MixPanelUtils.getToken());

        analyticsManager = new AnalyticsManager(this);

    }

    public void onRunning(View view) throws JSONException {

        mixpanelAPI.track(MixPanelUtils.Events.RUNNING,
                MixPanelUtils.propCreator()
                        .addProperty("Gender", "Male")
                        .addProperty("Location", "Atlanta")
                        .build()
        );

    }

    public void onJump(View view) throws JSONException {

        mixpanelAPI.track(MixPanelUtils.Events.JUMPING,
                MixPanelUtils.propCreator().addProperty("Height", "50ft")
                        .build());
    }

    public void onSkyDiving(View view) {
        analyticsManager.track(MixPanelUtils.Events.SKYDIVING);
    }

    public void onSwimming(View view) throws JSONException {

        analyticsManager.track(MixPanelUtils.Events.SWIMMING,
                MixPanelUtils.propCreator()
                        .addProperty("distance", "40ft")
                        .build());
    }

    public void onStartTimedEvent(View view) {

        analyticsManager.timeEvent(MixPanelUtils.Events.TIME);
    }

    public void onElapsedTime(View view) {

        String elapsedTime = String.valueOf
                (analyticsManager
                        .getElapsedTime(MixPanelUtils.Events.TIME));

        Toast.makeText(this,
                elapsedTime, Toast.LENGTH_SHORT).show();
    }

    public void onTrackTimedEvent(View view) {
        analyticsManager.track(MixPanelUtils.Events.TIME);

    }
}
