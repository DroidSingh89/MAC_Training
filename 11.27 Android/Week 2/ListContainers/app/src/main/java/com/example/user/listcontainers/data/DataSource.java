package com.example.user.listcontainers.data;

import com.example.user.listcontainers.model.Animal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by singh on 12/6/17.
 */

public class DataSource {

    public static List<String> getSimpleData(int size) {

        List<String> stringList = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            String s = "Sample random data string no: "
                    + new Random().nextInt(100);
            stringList.add(s);

        }
        return stringList;
    }

    public static List<Animal> getAnimalList() {
        List<Animal> animalList = new ArrayList<>();

        animalList.add(new Animal("Tiger", "400lbs", "Cats"));
        animalList.add(new Animal("Chimpanzee", "100lbs", "Mammal"));
        animalList.add(new Animal("Python", "45lbs", "Snake"));
        animalList.add(new Animal("Pit bull", "80lbs", "Dog"));

        return animalList;


    }


}
