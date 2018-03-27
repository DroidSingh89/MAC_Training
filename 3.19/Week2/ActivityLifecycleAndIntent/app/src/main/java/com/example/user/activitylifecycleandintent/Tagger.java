package com.example.user.activitylifecycleandintent;

/**
 * Created by singh on 3/27/18.
 */

public class Tagger {

    public static String get(Object o){

        return o.getClass().getSimpleName() + "_TAG";
    }
}
