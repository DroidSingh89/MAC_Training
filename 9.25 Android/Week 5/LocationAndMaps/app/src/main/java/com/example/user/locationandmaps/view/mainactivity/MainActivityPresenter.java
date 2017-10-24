package com.example.user.locationandmaps.view.mainactivity;

import android.content.Context;

import com.example.user.locationandmaps.data.DatabaseHelper;

/**
 * Created by singh on 10/24/17.
 */

public class MainActivityPresenter implements MainActivityContract.Presenter {


    MainActivityContract.View view;
    DatabaseHelper databaseHelper;

    public MainActivityPresenter(DatabaseHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }

    @Override
    public void attachView(MainActivityContract.View View) {
        this.view = View;
    }

    @Override
    public void detach() {

        this.view = null;
    }

    @Override
    public void getLocation() {
        databaseHelper.saveData("current location");
        view.updateLocation();
    }
}
