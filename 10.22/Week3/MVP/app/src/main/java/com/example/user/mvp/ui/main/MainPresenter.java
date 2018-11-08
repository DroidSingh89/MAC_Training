package com.example.user.mvp.ui.main;

public class MainPresenter implements MainContract.Presenter {

    MainContract.View view;


    @Override
    public void manipulateString(String rawString) {

        rawString = rawString.concat("other stuff");
        view.onManipulationResult(rawString);

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
