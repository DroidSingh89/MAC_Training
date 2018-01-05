package com.example.user.firebase.di.module;

import android.app.Activity;
import android.content.Context;

import com.example.user.firebase.view.login.LoginAuthenticator;
import com.example.user.firebase.view.login.LoginPresenter;
import com.google.firebase.auth.FirebaseAuth;

import dagger.Module;
import dagger.Provides;

/**
 * Created by singh on 12/21/17.
 */

@Module
public class LoginModule {

    Activity activity;


    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    @Provides
    LoginPresenter providesLoginPresenter(LoginAuthenticator loginAuthenticator) {
        loginAuthenticator.attach(activity);
        return new LoginPresenter(loginAuthenticator);
    }
}
