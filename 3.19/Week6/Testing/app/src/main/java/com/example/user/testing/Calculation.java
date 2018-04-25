package com.example.user.testing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculation {


    Addition addition;
    Multiplication multiplication;
    int INCREMENT;

    public Calculation(Addition addition, Multiplication multiplication, int INCREMENT) {
        this.addition = addition;
        this.multiplication = multiplication;
        this.INCREMENT = INCREMENT;
    }

    public int add(int a, int b) {
        return addition.add(a, b) + INCREMENT;
    }

    public int addSimple(int a, int b) {
        return a + b;
    }

    public List<Object> getSampleList() {
        List<Object> objects = new ArrayList<>();
        objects.add(1);
        objects.add(2);
        objects.add(3);
        return objects;
    }

    public void setupAddition() {
        addition.setup();
    }


}
