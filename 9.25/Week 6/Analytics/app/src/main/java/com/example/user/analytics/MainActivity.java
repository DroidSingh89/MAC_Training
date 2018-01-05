package com.example.user.analytics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.mixpanel.android.mpmetrics.MixpanelAPI;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private static final String MY_TIME_EVENT = "MyTimeEvent";
    private static final String TAG = "MainActivityTag";
    private MixpanelAPI mixpanel;
    private boolean isDownloaded;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");

        mixpanel = MixpanelAPI.getInstance(this, BuildConfig.mixpanelToken);


    }


    public void onJump(View view) {
        try {
            JSONObject props = new JSONObject();
            props.put("Gender", "Male");
            props.put("Logged in", true);
            props.put("activity", "Jumping");
            mixpanel.track("MainActivity - onJump called", props);
        } catch (JSONException e) {
            Log.e("MYAPP", "Unable to add properties to JSONObject", e);
        }

    }

    public void onPowerSlide(View view) {
        try {
            JSONObject props = new JSONObject();
            props.put("Gender", "Female");
            props.put("Logged in", true);
            props.put("activity", "Skydiving");
            mixpanel.track("MainActivity - onSkydive called", props);
        } catch (JSONException e) {
            Log.e("MYAPP", "Unable to add properties to JSONObject", e);
        }
    }

    public void onSkydive(View view) {

        try {
            JSONObject props = new JSONObject();
            props.put("Gender", "Male");
            props.put("Logged in", true);
            props.put("activity", "Skydive");
            mixpanel.track("MainActivity - onSkydive called", props);
        } catch (JSONException e) {
            Log.e("MYAPP", "Unable to add properties to JSONObject", e);
        }
    }

    public void onAttack(View view) {

        try {
            JSONObject props = new JSONObject();
            props.put("Gender", "Female");
            props.put("Logged in", true);
            props.put("activity", "Attack");
            mixpanel.track("MainActivity - onAttack called", props);
        } catch (JSONException e) {
            Log.e("MYAPP", "Unable to add properties to JSONObject", e);
        }
    }


    public void StartTime(View view) {
        mixpanel.timeEvent(MY_TIME_EVENT);
        isDownloaded = true;

    }

    public void TrackTime(View view) {

        if(isDownloaded){
            mixpanel.track(MY_TIME_EVENT);
        }

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mixpanel.flush();

    }


}
