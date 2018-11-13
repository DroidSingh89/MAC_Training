package com.example.user.androidnetworking.ui.user;

import com.example.user.androidnetworking.model.randomresponse.User;
import com.example.user.androidnetworking.ui.base.BasePresenter;
import com.example.user.androidnetworking.ui.base.BaseView;

import java.util.List;

public interface UserContract {

    interface View extends BaseView {

        void onRandomUsers(List<User> users);
    }

    interface Presenter extends BasePresenter<View> {

        void getRandomUsers(String gender, int results);
    }

}
