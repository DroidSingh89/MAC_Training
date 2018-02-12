package com.example.user.mvp_dagger.view.main;

import android.util.Log;

import com.example.user.mvp_dagger.Dependency;
import com.example.user.mvp_dagger.Dependent;
import com.example.user.mvp_dagger.model.StringBean;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by singh on 2/8/18.
 */

public class MainPresenter implements MainContract.Presenter {

    MainContract.View view;

    List<String> strings;
    @Override
    public void attachView(MainContract.View view) {
        this.view = view;
        strings = new ArrayList<>();
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void updateTextView(String string) {

        //after the logic
        if (string.isEmpty()) {
            view.showError("Edittext is empty");

        } else {

            StringBean stringBean = new StringBean(string);
            view.onUpdateTextView(stringBean);

        }
    }

    @Override
    public void addToList(String s) {
        view.onStringAdded(strings.add(s));
    }

    @Override
    public void getStringList() {

        view.onListReceived(strings);

    }

//    simple example for demonstrating dependency injection
    public void testDependent() {


        Dependency dependency = new Dependency(3, 4);
        //constructor injection
        Dependent dependent = new Dependent(dependency);

        //method injection
        dependent.setDependency(dependency);

        Log.d(TAG, "testDependent: " + dependent.add());
    }

}
