package com.example.user.multithreading.utils;

import android.util.Log;

public class Tagger {

    public static String get(Object object) {
        return object.getClass().getSimpleName() + "_TAG";
    }
}
