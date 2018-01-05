package com.example.user.firebase.di.component;

import com.example.user.firebase.di.module.LoginModule;
import com.example.user.firebase.view.login.LoginActivity;

import dagger.Subcomponent;

/**
 * Created by singh on 12/21/17.
 */

@Subcomponent(modules = LoginModule.class)
public interface LoginComponent {

    void inject(LoginActivity loginActivity);
}
