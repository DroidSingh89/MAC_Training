package com.example.user.webviewsandsqlite;

import android.content.Context;

/**
 * Created by singh on 8/7/17.
 */

public class ClassicSingleton {

    private Context context;

    private static ClassicSingleton instance = null;

    public ClassicSingleton(Context context) {
        this.context = context;
    }

    public ClassicSingleton(){

    }

    public static ClassicSingleton getInstance(Context context) {

        if (instance == null) {
            instance = new ClassicSingleton(context);
        }
        return instance;

    }



}
