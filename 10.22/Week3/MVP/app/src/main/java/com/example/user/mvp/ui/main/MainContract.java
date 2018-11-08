package com.example.user.mvp.ui.main;

import com.example.user.mvp.ui.base.BasePresenter;
import com.example.user.mvp.ui.base.BaseView;

public interface MainContract {


    //communicate from presenter to the view
    interface View extends BaseView {

        void onManipulationResult(String manipulatedString);
    }

    //communicate from view to the presenter
    interface Presenter extends BasePresenter<View> {

        void manipulateString(String rawString);
    }

}

