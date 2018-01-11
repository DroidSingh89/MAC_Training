package com.example.user.androidarchitecturecomponents;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by singh on 1/11/18.
 */

public class Testing {

    public static void main(String[] args) {

        int number = 23423;
        String[] integers = String.valueOf(number).split("");
        List<String> integersList = Arrays.asList(integers);
        Collections.sort(integersList, Collections.<String>reverseOrder());
        String newValue = "";
        for (String s: integersList) {
            newValue += s;
        }

        System.out.println(newValue);


    }
}
