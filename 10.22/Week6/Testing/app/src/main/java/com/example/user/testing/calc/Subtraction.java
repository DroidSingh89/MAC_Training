package com.example.user.testing.calc;

import android.util.Log;

public class Subtraction {

    private static final String TAG = Subtraction.class.getSimpleName()+ "_TAG";

    public void subtract(int a, int b){
        Log.d(TAG, "subtract: "+ (a-b));
    }
}
