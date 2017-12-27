package com.example.user.firebase.utils;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.example.user.firebase.di.component.AppComponent;
import com.example.user.firebase.di.component.DaggerAppComponent;
import com.example.user.firebase.di.component.LoginComponent;
import com.example.user.firebase.di.component.MovieComponent;
import com.example.user.firebase.di.module.AppModule;
import com.example.user.firebase.di.module.LoginModule;
import com.example.user.firebase.di.module.MovieModule;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by singh on 12/21/17.
 */

public class FireBaseApplication extends Application {

    AppComponent appComponent;
    LoginComponent loginComponent;
    MovieComponent movieComponent;
    private FirebaseDatabase firebaseDatabase;
    private FirebaseAuth firebaseAuth;
    private LoginModule loginModule;
    Context context1;


    @Override
    public void onCreate() {
        super.onCreate();

        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();

        AppModule appModule = new AppModule(firebaseDatabase, firebaseAuth);
        appComponent = DaggerAppComponent.builder()
                .appModule(appModule)
                .build();

        createMovieComponent();
        createLoginComponent();
    }

    public static FireBaseApplication get(Context context) {

        return (FireBaseApplication) context.getApplicationContext();
    }


    public void createMovieComponent(){
        movieComponent = appComponent.add(new MovieModule());
    }
    public MovieComponent getMovieComponent() {
        return movieComponent;

    }

    public void clearMovieComponent() {
        movieComponent = null;
    }


    public void createLoginComponent(){

        loginModule = new LoginModule();
        loginComponent = appComponent.add(loginModule);
    }
    public LoginComponent getLoginComponent(Activity activity) {
        loginModule.setActivity(activity);
        return loginComponent;

    }

    public void clearLoginComponent() {
        loginComponent = null;
    }



}
