package com.example.singh.mvp_dagger.view.activites.mainactivity;

import com.example.singh.mvp_dagger.model.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by singh on 7/12/17.
 */

public class MainActivityPresenter implements MainActivityContract.Presenter{

    MainActivityContract.View view;

    List<Person> personList = new ArrayList<>();


    @Override
    public void getFullName(String firstName, String lastName) {

        view.setFullName(firstName + " " + lastName);

    }

    @Override
    public void addPerson(Person person) {
        personList.add(person);



    }

    @Override
    public void sendToSecondActivity() {
        view.sendPersonList(personList);
    }

    @Override
    public void addView(MainActivityContract.View view) {

        this.view = view;
    }

    @Override
    public void removeView() {

        this.view = null;
    }
}
