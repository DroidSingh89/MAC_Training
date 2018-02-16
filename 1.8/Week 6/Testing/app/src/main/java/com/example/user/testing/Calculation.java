package com.example.user.testing;

/**
 * Created by singh on 2/16/18.
 */

public class Calculation {


    Addition addition;
    Multiplication multiplication;

    int val1, val2;


    public Calculation(Addition addition, Multiplication multiplication) {
        this.addition = addition;
        this.multiplication = multiplication;
    }

    public void setValues(int val1, int val2) {

        this.val1 = val1;
        this.val2 = val2;

    }

    public int multiply(int a, int b) {
        return  multiplication.multiply(a, b);
    }

    public int multiplyTen(int a, int b) {
        return multiplication.multiply(a, b) * 10;
    }

    public void clearValues() {
        this.val1 = 0;
        this.val2 = 0;
    }

    public int add(int a, int b) {
        return a + b;

    }

    public int addTen(int a, int b) {
        return addition.add(a, b) + 10;
    }


}
