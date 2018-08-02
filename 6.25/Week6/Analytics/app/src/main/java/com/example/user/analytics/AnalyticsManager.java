package com.example.user.analytics;

import android.content.Context;

import com.mixpanel.android.mpmetrics.MixpanelAPI;

public class AnalyticsManager {

    public static class Events {
        public static final String RUN = "run";
        public static final String JUMP = "jump";
        public static final String SKYDIVE = "skydive";
        public static final String SWIM = "swim";
        public static final String LOAD_IMAGE = "load_image";

    }

    private MixpanelAPI mixpanelAPI;
    private static final String TOKEN = "9f5ff28f57b37917cc7c3ce672a8793b";

    public AnalyticsManager(Context context) {
        mixpanelAPI = MixpanelAPI.getInstance(context, TOKEN);
    }

    public void trackEvent(Event event) {

        if (event.getName().equals(Events.LOAD_IMAGE)) {
            mixpanelAPI.track(event.getName());
        } else {

            mixpanelAPI.track(event.getName(), event.getProps());
        }
    }

    public void timeEvent(Event event) {

        mixpanelAPI.timeEvent(event.getName());

    }

}
