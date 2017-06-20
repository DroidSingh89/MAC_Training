package com.example.singh.codingtest;

/**
 * Created by Android on 6/20/2017.
 */

public class Codingtest {
    public static void main(String[] args) {


        //Problem one
        //Create a fundtion to print fiboncacci series


        //Problem two
        //Input
        System.out.println("have a nice day");
        //Output
        System.out.println("day nice a have");

        Reverse();


    }

    public static void Reverse() {

        String start = "Have a nice day";
        String end = "";
        String regex =("\\s");
        String words[] = start.split(regex) ;
        for (int i = words.length-1; i>=0; i--) {
            end += words[i]+" ";
        }
        System.out.println(end);
    }

}
