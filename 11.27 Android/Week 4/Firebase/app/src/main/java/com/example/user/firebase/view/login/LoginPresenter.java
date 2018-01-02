package com.example.user.firebase.view.login;

import com.google.firebase.auth.FirebaseUser;

/**
 * Created by singh on 12/20/17.
 */

public class LoginPresenter implements
        LoginContract.Presenter,
        LoginAuthenticator.OnLoginInteraction,
        LoginAuthenticator.OnSignOutInteraction {

    LoginContract.View view;
    LoginAuthenticator loginAuthenticator;

    public LoginPresenter(LoginAuthenticator loginAuthenticator) {
        this.loginAuthenticator = loginAuthenticator;
        loginAuthenticator.attach(this);
    }

    @Override
    public void attachView(LoginContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void signOut() {

    }

    @Override
    public void validateUser(String email, String password) {
        loginAuthenticator.validateUser(email, password, this);
    }

    @Override
    public void createUser(String email, String password) {
        loginAuthenticator.createUser(email, password, this);
    }

    @Override
    public void checkSession() {
        loginAuthenticator.checkUser();
    }


    @Override
    public void onUserCreation(FirebaseUser user) {
        if (user != null)
            view.onUserCreation(true);
        else
            view.onUserCreation(false);
    }

    @Override
    public void onUserValidation(FirebaseUser user) {
        if (user != null)
            view.onUserValidation(true);
        else
            view.onUserValidation(false);
    }

    @Override
    public void onSessionValid(boolean isValid) {
        view.isSessionValid(isValid);
    }

    @Override
    public void onSignOut(boolean isSignedOut) {

    }
}
