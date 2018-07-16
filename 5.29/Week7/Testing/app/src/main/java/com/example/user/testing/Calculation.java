package com.example.user.testing;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class Calculation {


    private Addition addition;

    public Calculation(Addition addition) {
        this.addition = addition;
    }

    //    testing logic with unit testing
    public int add(int a, int b) {

        return a + b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    //    testing with mocking addition class
    public int addTen(int a, int b) {

        return addition.add(a, b) + 10;
    }

    public void something() {
        addition.something();

    }


    public int divide(int a, int b) {
        return a / b;
    }


    public List<String> getList() {
        List<String> strings = new ArrayList<>();
        strings.add("A");
        strings.add("B");
        strings.add("C");

        return strings;
    }
}
