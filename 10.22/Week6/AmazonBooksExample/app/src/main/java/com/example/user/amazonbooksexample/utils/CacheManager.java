package com.example.user.amazonbooksexample.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

public class CacheManager {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private static final String TIME = "time";
    private static final long TIME_LIMIT = 20000;

    @SuppressLint("CommitPrefEdits")
    public CacheManager(Context context) {
        sharedPreferences = context.getSharedPreferences("mySharedPref", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

    }

    public void saveTime(long time) {

        editor.putLong(TIME, time);
        editor.commit();
    }

    private long getLastTime() {
        return sharedPreferences.getLong(TIME, 0);
    }

    public boolean isCacheDirty() {
        long currentTime = System.currentTimeMillis();
        long timeDiff = currentTime - getLastTime();
        return timeDiff > TIME_LIMIT;

    }


}
