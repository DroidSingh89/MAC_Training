package com.example.user.firebase.calculation;

public class Addition {

    int increment;

    public Addition(int increment) {
        this.increment = increment;
    }

    public int add(int a, int b) {
        return a + b + increment;
    }
}
