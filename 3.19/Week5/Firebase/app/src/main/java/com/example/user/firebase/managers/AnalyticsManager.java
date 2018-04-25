package com.example.user.firebase.managers;

import android.content.Context;
import android.os.Bundle;

import com.example.user.firebase.model.events.HelloEvent;
import com.google.firebase.analytics.FirebaseAnalytics;

public class AnalyticsManager {


    FirebaseAnalytics firebaseAnalytics;

    public AnalyticsManager(Context context) {
        firebaseAnalytics = FirebaseAnalytics.getInstance(context);
    }

    public void logEvent(HelloEvent helloEvent) {
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, helloEvent.getId());
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, helloEvent.getValue());
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "hello");
        firebaseAnalytics.logEvent("movie_saved", bundle);
    }
}
