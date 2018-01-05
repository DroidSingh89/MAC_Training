package com.example.user.analytics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.mixpanel.android.mpmetrics.MixpanelAPI;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String YOUR_PROJECT_TOKEN = "70b35e88989dfb5d55f1cb0380f36ded";
    private static final String TIME_EVENT_DOWNLOAD = "FILE_DOWNLOAD";
    private MixpanelAPI mixpanel;
    private boolean isDownloading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String projectToken = YOUR_PROJECT_TOKEN; // e.g.: "1ef7e30d2a58d27f4b90c42e31d6d7ad" 
        mixpanel = MixpanelAPI.getInstance(this, projectToken);
    }


    public void onJump(View view) {

        try {
            JSONObject props = new JSONObject();
            props.put("Activity", "Jumping");
            props.put("Random", getRandomInt());
            mixpanel.track("MainActivity - onJump called", props);
        } catch (JSONException e) {
            Log.e("MYAPP", "Unable to add properties to JSONObject", e);
        }

    }

    public void onRun(View view) {
        try {
            JSONObject props = new JSONObject();
            props.put("Activity", "Running");
            props.put("Random", getRandomInt());
            mixpanel.track("MainActivity - onRun called", props);
        } catch (JSONException e) {
            Log.e("MYAPP", "Unable to add properties to JSONObject", e);
        }
    }

    public void onSkydive(View view) {
        try {
            JSONObject props = new JSONObject();
            props.put("Activity", "Skydiving");
            props.put("Random", getRandomInt());
            mixpanel.track("MainActivity - onSkydive called", props);
        } catch (JSONException e) {
            Log.e("MYAPP", "Unable to add properties to JSONObject", e);
        }
    }

    public void onSleep(View view) {
        try {
            JSONObject props = new JSONObject();
            props.put("Activity", "Sleeping");
            props.put("Random", getRandomInt());
            mixpanel.track("MainActivity - onSleep called", props);
        } catch (JSONException e) {
            Log.e("MYAPP", "Unable to add properties to JSONObject", e);
        }
    }

    public void onStartTimer(View view) {
        mixpanel.timeEvent(TIME_EVENT_DOWNLOAD);
        isDownloading = true;
    }

    public void onStopTimer(View view) {
        if (isDownloading)
            mixpanel.track(TIME_EVENT_DOWNLOAD);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mixpanel.flush();
    }

    public int getRandomInt() {
        return new Random().nextInt(100);
    }

}
