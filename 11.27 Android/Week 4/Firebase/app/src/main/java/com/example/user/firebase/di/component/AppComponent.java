package com.example.user.firebase.di.component;

import com.example.user.firebase.di.module.AppModule;
import com.example.user.firebase.di.module.LoginModule;
import com.example.user.firebase.di.module.MovieModule;

import dagger.Component;

/**
 * Created by singh on 12/21/17.
 */

@Component(modules = AppModule.class)
public interface AppComponent {

    LoginComponent add(LoginModule loginModule);

    MovieComponent add(MovieModule movieModule);
}
