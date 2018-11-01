package com.example.user.listlikeviews.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PersonGenerator {

    public static List<Person> generate(int count) {
        List<Person> personList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            personList.add(new Person(getRandomName(), getRandomAge(), getRandomGender()));
        }
        return personList;

    }

    private static String getRandomName() {

        List<String> names = new ArrayList<>();
        names.add("Josh");
        names.add("Assem");
        names.add("Nathan");
        names.add("Keenan");
        names.add("Tim");
        names.add("Michael");
        names.add("Bernardo");
        return names.get(new Random().nextInt(names.size()));
    }

    private static String getRandomAge() {

        return String.valueOf(new Random().nextInt(40));
    }

    private static String getRandomGender() {

        List<String> genders = new ArrayList<>();
        genders.add("Male");
        genders.add("Female");
        return genders.get(new Random().nextInt(2));

    }


}
