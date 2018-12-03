package com.example.user.testing.calc;

import com.example.user.testing.ListProvider;

import java.util.List;

public class Calculation {


    private Multiplication multiplication;
    private Subtraction subtraction;
    private ListProvider listProvider;


    Calculation(Multiplication multiplication, Subtraction subtraction, ListProvider listProvider) {
        this.multiplication = multiplication;
        this.subtraction = subtraction;
        this.listProvider = listProvider;
    }

//    testing simple method
    public int add(int a, int b) {
        return a + b;
    }

//    testing with mocked object
    int multiply10(int a, int b) {
        return multiplication.multiply(a, b) * 10;
    }

//    testing void method
    void subtract(int a, int b) {
        a++;
        subtraction.subtract(a, b);
    }

//    testing list
    public List<String> getList() {

        List<String> newRawList = listProvider.getRawList();
        newRawList.add("F");
        return newRawList;

    }


}
