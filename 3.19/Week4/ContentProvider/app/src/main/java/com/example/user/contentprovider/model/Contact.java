package com.example.user.contentprovider.model;

import java.util.List;

public class Contact {

    String name;
    List<String> numberList;

    public Contact(String name, List<String> numberList) {
        this.name = name;
        this.numberList = numberList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getNumberList() {
        return numberList;
    }

    public void setNumberList(List<String> numberList) {
        this.numberList = numberList;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", numberList=" + numberList +
                '}';
    }
}
