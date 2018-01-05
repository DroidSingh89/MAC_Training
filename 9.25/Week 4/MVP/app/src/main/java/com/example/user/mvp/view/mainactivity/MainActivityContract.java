package com.example.user.mvp.view.mainactivity;

import com.example.user.mvp.BasePresenter;
import com.example.user.mvp.BaseView;

/**
 * Created by singh on 10/18/17.
 */

public interface MainActivityContract {


    interface View extends BaseView{

        void setFullName(String fullName);


    }

    interface Presenter extends BasePresenter<View>{

        void getFullName(String firstname);
    }

}
