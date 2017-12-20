package com.example.user.firebase.view.login;

import com.example.user.firebase.utils.BasePresenter;
import com.example.user.firebase.utils.BaseView;

/**
 * Created by singh on 12/20/17.
 */

public interface LoginContract {

    interface View extends BaseView {

        void onUserCreation(boolean isCreated);

        void onUserValidation(boolean isValid);

        void isSessionValid(boolean isValid);

    }

    interface Presenter extends BasePresenter<View> {

        void validateUser(String email, String password);

        void createUser(String email, String password);

        void checkSession();

    }
}
