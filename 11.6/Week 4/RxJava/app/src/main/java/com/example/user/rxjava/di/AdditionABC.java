package com.example.user.rxjava.di;

/**
 * Created by singh on 11/29/17.
 */

public class AdditionABC extends Addition {

    @Override
    public int add(int a, int b) {
        return super.add(a, b) + 5;
    }
}
