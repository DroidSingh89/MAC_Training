package com.example.user.testing;

public class Calculation {


    private Multiplication multiplication;

    Calculation(Multiplication multiplication) {
        this.multiplication = multiplication;
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int multiply10(int a, int b) {
        return multiplication.multiply(a, b) * 10;
    }
}
