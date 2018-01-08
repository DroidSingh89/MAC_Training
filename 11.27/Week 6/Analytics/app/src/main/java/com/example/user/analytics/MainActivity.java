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

    public static final String TOKEN = "44f04dcffbb21b81c47fc2f535734b39";
    private static final String DOWNLOAD_IMAGE_EVENT = "DownloadImage";
    private MixpanelAPI mixpanel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mixpanel = MixpanelAPI.getInstance(this, TOKEN);

    }

    public void onRun(View view) {

        trackButtonClick("onRun");
    }

    public void onJump(View view) {
        trackButtonClick("onJump");
    }

    public void onSwim(View view) {
        trackButtonClick("onSwim");
    }

    public void onSkydive(View view) {
        trackButtonClick("onSkydive");
    }

    public void onDownload(View view) {
        mixpanel.timeEvent(DOWNLOAD_IMAGE_EVENT);
    }

    public void onDownloadComplete(View view) {
        mixpanel.track(DOWNLOAD_IMAGE_EVENT);
    }

    private void trackButtonClick(String button) {
        try {
            JSONObject props = new JSONObject();
            props.put("Gender", "Female");
            props.put("Random", getRandomValue());
            mixpanel.track("MainActivity - " + button + " called", props);
        } catch (JSONException e) {
            Log.e("MYAPP", "Unable to add properties to JSONObject", e);
        }
    }

    private int getRandomValue() {
        return new Random().nextInt(50);
    }
}
