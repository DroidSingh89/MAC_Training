package com.example.user.firebase.calculation;

public class Calculation {

    Addition addition;

    public Calculation(Addition addition) {
        this.addition = addition;
    }

    public int add(int a, int b) {
        return addition.add(a, b);
    }

}
