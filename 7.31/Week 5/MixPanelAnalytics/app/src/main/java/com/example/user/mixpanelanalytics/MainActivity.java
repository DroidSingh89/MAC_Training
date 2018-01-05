package com.example.user.mixpanelanalytics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.mixpanel.android.mpmetrics.MixpanelAPI;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private static final String YOUR_PROJECT_TOKEN = "31466c9bee464ca86354689b349ab7fd";
    MixpanelAPI mixpanel;
    private String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String projectToken = YOUR_PROJECT_TOKEN;
        mixpanel = MixpanelAPI.getInstance(this, projectToken);

        data = "asdf";
    }

    public void onJump(View view) {

        try {
            JSONObject props = new JSONObject();
            props.put("Activity", "Jump");
            props.put("Status", "Done");
            mixpanel.track("MainActivity - onJump called", props);
        } catch (JSONException e) {
            Log.e("MYAPP", "Unable to add properties to JSONObject", e);
        }
    }

    public void onShoot(View view) {
        try {
            JSONObject props = new JSONObject();
            props.put("Activity", "Shoot");
            props.put("Status", "Why would I shoot");
            mixpanel.track("MainActivity - onShoot called", props);
        } catch (JSONException e) {
            Log.e("MYAPP", "Unable to add properties to JSONObject", e);
        }
    }

    public void onSkydive(View view) {
        try {
            JSONObject props = new JSONObject();
            props.put("Activity", "Skydive");
            props.put("Status", "At 13000 feet");
            mixpanel.track("MainActivity - onSkydive called", props);
        } catch (JSONException e) {
            Log.e("MYAPP", "Unable to add properties to JSONObject", e);
        }
    }

    public void onDrive(View view) {
        try {
            JSONObject props = new JSONObject();
            props.put("Activity", "Drive");
            props.put("Status", "At 60mph");
            mixpanel.track("MainActivity - onDrive called", props);
        } catch (JSONException e) {
            Log.e("MYAPP", "Unable to add properties to JSONObject", e);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mixpanel.flush();

    }
}
