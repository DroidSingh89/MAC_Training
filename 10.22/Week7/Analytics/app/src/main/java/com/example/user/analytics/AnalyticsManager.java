package com.example.user.analytics;

import android.content.Context;

import com.mixpanel.android.mpmetrics.MixpanelAPI;

import org.json.JSONException;
import org.json.JSONObject;

public class AnalyticsManager {

    private static final String TOKEN = "5d2a6ed9bce772741d3f6ff9346eef99";

    private MixpanelAPI mixpanelAPI;

    AnalyticsManager(Context context) {
        mixpanelAPI = MixpanelAPI.getInstance(context, TOKEN);
    }


    public void track(String event, String propName, String propValue) throws JSONException {

        JSONObject props = new JSONObject();
        props.put(propName, propValue);
        mixpanelAPI.track(event, props);

    }


    static class Event {

        static final String JUMP = "onJumpActivity";
        static final String RUN = "onRunActivity";
        static final String SWIM = "onSwimActivity";
        static final String SKYDIVE = "onSkydiveActivity";
    }


}
