package com.example.user.testing;

/**
 * Created by singh on 10/25/17.
 */

public class Calculation {


    int val1 = 0;
    int val2 = 0;


    Addition addition;

    public Calculation(Addition addition) {
        this.addition = addition;
    }

    public int addTen() {

        return addition.add(val1, val2) + 10;

    }

    public int addition() {

        return val1 + val2;

    }

    public String calculationString(String a, String b){

        return addition.addtionString(a) + b;
    }


    public int subtraction() {

        return val1 - val2;

    }

    public void setVal1(int val1) {
        this.val1 = val1;
    }

    public void setVal2(int val2) {
        this.val2 = val2;
    }

    public void clear() {
        val1 = 0;
        val2 = 0;
    }


}
