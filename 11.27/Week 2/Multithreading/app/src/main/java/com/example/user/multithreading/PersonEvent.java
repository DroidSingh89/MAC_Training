package com.example.user.multithreading;

/**
 * Created by singh on 12/5/17.
 */

public class PersonEvent {

    String name;
    String age;


    @Override
    public String toString() {
        return "PersonEvent{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public PersonEvent(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
