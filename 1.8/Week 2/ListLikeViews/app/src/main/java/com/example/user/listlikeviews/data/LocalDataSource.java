package com.example.user.listlikeviews.data;

import com.example.user.listlikeviews.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by singh on 1/16/18.
 */

public class LocalDataSource {


    public static List<Person> getPersonList() {

        List<Person> personList = new ArrayList<>();

        personList.add(new Person("Tom Cruise", "53", "Male"));
        personList.add(new Person("Jim Carrey", "57", "Male"));
        personList.add(new Person("Bill Gates", "63", "Male"));
        personList.add(new Person("Jennifer Anniston", "53", "Female"));
        personList.add(new Person("Kate Middleton", "30", "Female"));
        personList.add(new Person("Dave Chappelle", "47", "Male"));

        return personList;
    }

    public static List<String> getSimpleData(int items) {
        List<String> stringList = new ArrayList<>();

        for (int i = 0; i < items; i++) {
            stringList.add("Item no: " + getRandomNumber());
        }
        return stringList;

    }

    private static String getRandomNumber() {
        return String.valueOf(new Random().nextInt(100));

    }
}
