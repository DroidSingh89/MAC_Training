package com.example.user.contentprovider;

import java.util.List;

public class Contact {

    String name;

    List<String> number;

    public Contact(String name, List<String> number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public List<String> getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}
