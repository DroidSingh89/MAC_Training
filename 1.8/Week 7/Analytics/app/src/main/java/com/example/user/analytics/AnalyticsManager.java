package com.example.user.analytics;

import android.content.Context;

import com.mixpanel.android.mpmetrics.MixpanelAPI;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Random;

/**
 * Created by singh on 2/19/18.
 */

public class AnalyticsManager {

    MixpanelAPI mixpanelAPI;
    public static final String PROJECT_TOKEN = "ce08fc2f8feaa9b40fa82f35a87d0e10";

    public AnalyticsManager(Context context) {
        mixpanelAPI = MixpanelAPI.getInstance(context, PROJECT_TOKEN);
    }

    public void track(String activity) throws JSONException {

        if (!activity.equals(Activity.TIMER)) {
            JSONObject properties = new JSONObject();
            properties.put("country", "USA");
            properties.put("gender", "Male");
            properties.put("randomValue", new Random().nextInt(100));
            properties.put("activity", activity);
            mixpanelAPI.track(activity + " was called", properties);
        } else {
            mixpanelAPI.track(activity);
        }

    }

    public void timeEvent(String timer) {

        mixpanelAPI.timeEvent(timer);
    }
}
