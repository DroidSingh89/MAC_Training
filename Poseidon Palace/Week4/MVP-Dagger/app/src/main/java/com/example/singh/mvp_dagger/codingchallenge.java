package com.example.singh.mvp_dagger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by singh on 8/1/17.
 */

public class codingchallenge {


    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("Hello, World!");
        strings.add("Welcome to CoderPad.");
        strings.add("This pad is running Java 8.");

        for (String string : strings) {
            System.out.println(string);
        }



        System.out.println(findDuplicates(strings));

    }

    public static ArrayList<String> findDuplicates(ArrayList stringList) {

        HashMap<String, Integer> hashmap = new HashMap<>();

        int count = 0;

        ArrayList<String> duplicateList = new ArrayList<>();
        for (int i = 0; i < stringList.size(); i++) {

            if (hashmap.get(stringList.get(i)) != null) {
                count = hashmap.get(stringList.get(i));
                hashmap.put((String) stringList.get(i), count++);

                if(count==1){
                    duplicateList.add((String) stringList.get(i));
                }
            } else {
                hashmap.put((String) stringList.get(i), 1);
            }

        }

        return duplicateList;


    }
}
