package com.example.user.rxjava.di;

/**
 * Created by singh on 11/29/17.
 */

public class Calculation {



    Addition addition;

    public Calculation(Addition addition) {
        this.addition = addition;
    }

    public int add(int a, int b){

        return addition.add(a, b);
    }

}
