package com.example.user.encryption.model;

public class Person {

    String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "{\"Person\": {" +
                "\"name\": \"" + name + "\"" +
                "}}";
    }

    public String getName() {
        return name;
    }
}
