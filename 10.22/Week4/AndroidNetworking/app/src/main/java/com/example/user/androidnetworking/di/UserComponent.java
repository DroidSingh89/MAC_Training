package com.example.user.androidnetworking.di;

import com.example.user.androidnetworking.ui.user.UserActivity;

import dagger.Component;

@Component(modules = UserModule.class)
public interface UserComponent {

    void inject(UserActivity userActivity);
}
