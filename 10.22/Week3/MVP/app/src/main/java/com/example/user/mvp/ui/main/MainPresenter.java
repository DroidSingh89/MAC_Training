package com.example.user.mvp.ui.main;

import com.example.user.mvp.util.StringManipulator;

public class MainPresenter implements MainContract.Presenter {

    MainContract.View view;
    StringManipulator stringManipulator;

    public MainPresenter(StringManipulator stringManipulator) {
        this.stringManipulator = stringManipulator;
    }

    @Override
    public void manipulateString(String rawString) {

        view.onManipulationResult(stringManipulator.update(rawString));

    }

    @Override
    public void attachView(MainContract.View view) {
        this.view = view;

    }

    @Override
    public void detachView() {
        this.view = null;
    }
}
