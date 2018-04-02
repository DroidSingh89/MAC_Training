package com.example.user.listlikeviews.data;

import com.example.user.listlikeviews.model.Animal;

import java.util.ArrayList;
import java.util.List;

public class AnimalFactory {


    public static List<Animal> createAnimals() {
        List<Animal> animalList = new ArrayList<>();

        animalList.add(new Animal("Tiger", "400", "Cat"));
        animalList.add(new Animal("Python", "40", "Snake"));
        animalList.add(new Animal("Lion", "450", "Cat"));
        animalList.add(new Animal("Chimpanzee", "100", "Monkey"));
        animalList.add(new Animal("Parrot", "10", "Bird"));
        animalList.add(new Animal("Mountain Lion", "300", "Cat"));
        animalList.add(new Animal("Moose", "80", "Deer"));
        animalList.add(new Animal("Anaconda", "60", "Snake"));
        return animalList;
    }

    public static List<String> createSimpleAnimals() {

        List<String> strings = new ArrayList<>();
        strings.add("Tiger");
        strings.add("Python");
        strings.add("Lion");
        strings.add("Chimpanzee");
        strings.add("Parrot");
        return strings;

    }
}
