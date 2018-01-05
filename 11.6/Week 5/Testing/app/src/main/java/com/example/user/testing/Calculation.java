package com.example.user.testing;

import android.util.Log;

/**
 * Created by singh on 12/5/17.
 */

public class Calculation {

    int val1;
    int val2;

    Addition addition;

    public Calculation(Addition addition) {
        this.addition = addition;
    }

    public int add(){
        addition.something();
        addition.something();
        return addition.add(val1, val2) + 10;
    }

    public void something(){
        Log.d("CalculationTag", "something: ");
    }


    public void setVal1(int val1) {
        this.val1 = val1;
    }

    public void setVal2(int val2) {
        this.val2 = val2;
    }
}
