package com.example.user.activitylifecycleandintent.utils;

public class TagIt {

    public static String with(Object object) {
        return object.getClass().getSimpleName()+ "_TAG";
    }
}
