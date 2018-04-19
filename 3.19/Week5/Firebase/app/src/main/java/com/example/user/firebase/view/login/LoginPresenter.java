package com.example.user.firebase.view.login;

import com.example.user.firebase.managers.AuthManager;
import com.example.user.firebase.model.UserCredentials;
import com.google.firebase.auth.FirebaseUser;

public class LoginPresenter implements LoginContract.Presenter, AuthManager.ILoginInteraction{

    LoginContract.View view;
    AuthManager authManager;

    public LoginPresenter(AuthManager authManager) {
        authManager.attach(this);
        this.authManager = authManager;
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
    public void onLoginSuccess(FirebaseUser user) {
        view.onLoginSuccess(user);
    }

    @Override
    public void onLoginError(String error) {
        view.onLoginFailure(error);

    }

    @Override
    public void signIn(UserCredentials userCredentials) {

        authManager.signIn(userCredentials);
    }

    @Override
    public void register(UserCredentials userCredentials) {

        authManager.register(userCredentials);
    }

    @Override
    public boolean checkSession() {
        return authManager.checkSession();
    }
}
