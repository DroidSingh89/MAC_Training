package com.example.user.firebase.calculation;

public class Calc {

    public static void main(String[] args) {


        Addition addition = new Addition(0);
        Addition addition10 = new Addition(10);

        Calculation calculation = new Calculation(addition10);

        System.out.println(calculation.add(2, 3));

    }
}
