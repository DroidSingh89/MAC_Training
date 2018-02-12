package com.example.user.mvp_dagger;

/**
 * Created by singh on 2/9/18.
 */

public class Dependency {

    int a, b;

    public Dependency(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int add() {
        return a + b;
    }
}
