package com.example.user.mvp_dagger.view.mainactivity;

import com.example.user.mvp_dagger.injection.utils.DaggerUtilityComponent;
import com.example.user.mvp_dagger.utils.DatabaseHelper;

import javax.inject.Inject;

/**
 * Created by singh on 9/26/17.
 */

public class MainActivityPresenter implements MainActivityContract.Presenter {

    MainActivityContract.View view;

    @Inject
    DatabaseHelper databaseHelper;

    @Override
    public void attachView(MainActivityContract.View view) {
        this.view = view;

        DaggerUtilityComponent.create().injectMainPresenter(this);
        String data = databaseHelper.getData(4);
        this.view.showError(data);

    }

    @Override
    public void detachView() {

        this.view = null;
    }

    @Override
    public void validateInput(String inputString) {

        String outputString = "$" + inputString;

        if (inputString.equals("error"))
            view.showError("You typed error");
        else
            view.updateView(outputString);

    }
}
