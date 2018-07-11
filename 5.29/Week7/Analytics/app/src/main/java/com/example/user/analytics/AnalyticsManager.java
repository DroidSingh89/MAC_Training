package com.example.user.analytics;

import android.content.Context;

import com.mixpanel.android.mpmetrics.MixpanelAPI;

import org.json.JSONObject;

public class AnalyticsManager {

    MixpanelAPI mixpanelAPI;

    public AnalyticsManager(Context context) {
        mixpanelAPI = MixpanelAPI.getInstance(context, MixPanelUtils.getToken());
    }


    public void track(String event, JSONObject jsonObject) {
        mixpanelAPI.track(event, jsonObject);
    }

    public void track(String event) {
        mixpanelAPI.track(event);
    }

    public void timeEvent(String eventName) {
        mixpanelAPI.timeEvent(eventName);

    }

    public Double getElapsedTime(String eventName){
        return mixpanelAPI.eventElapsedTime(eventName);
    }



}
