package com.example.user.testing;

/**
 * Created by singh on 1/4/18.
 */

public class Calculation {

    Addition addition;
    Multiplication multiplication;

    public Calculation(Addition addition, Multiplication multiplication) {
        this.addition = addition;
        this.multiplication = multiplication;
    }

    public int add(int a, int b) {
        return addition.add(a, b) + 10;
    }
    public int multipy(int a, int b) {
        return multiplication.multiply(a, b) * 10;
    }


    public void clear() {

    }
}
