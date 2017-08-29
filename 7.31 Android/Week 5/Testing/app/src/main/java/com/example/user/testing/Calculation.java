package com.example.user.testing;

/**
 * Created by singh on 8/29/17.
 */

public class Calculation {


    int val1;
    int val2;


    Addition addition;
    Multiplication multiplication;
    Subtraction subtraction;
    Division division;


    public Calculation(Addition addition, Subtraction subtraction, Multiplication multiplication,Division division) {
        this.addition = addition;
        this.multiplication = multiplication;
        this.subtraction = subtraction;
        this.division = division;
    }

    public int addition() {

        return addition.add(val1, val2) + 5;
    }

    public int subtraction() {
        return subtraction.subtact(val1,val2) + 10;
    }

    public int multiply() {
        return multiplication.mulitply(val1,val2) + 20;
    }

    public int divide() {
        return division.divide(val1,val2) + 30;
    }

    public void clear(){

        val1 = 0;
        val2 = 0;

    }


    public void setVal1(int val1) {
        this.val1 = val1;
    }

    public void setVal2(int val2) {
        this.val2 = val2;
    }
}
