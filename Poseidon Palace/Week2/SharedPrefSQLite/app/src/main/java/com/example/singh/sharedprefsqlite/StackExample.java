package com.example.singh.sharedprefsqlite;

import java.util.Stack;

/**
 * Created by singh on 8/4/17.
 */

public class StackExample {

    public static void main(String[] args) {


        Stack stack = new Stack();

        //pushing items
        stack.push("one");
        stack.push("two");
        stack.push("three");
        stack.push("four");


        //printing the size
        System.out.println(stack.size());
        int stackSize = stack.size();

        //popping the items
        for (int i = 0; i < stackSize; i++) {

            System.out.println(stack.pop());

        }


    }




}
