package com.example.user.firebase.utils;

import android.app.Application;
import android.content.Context;

import com.example.user.firebase.di.component.AppComponent;
import com.example.user.firebase.di.component.DaggerAppComponent;
import com.example.user.firebase.di.component.LoginComponent;
import com.example.user.firebase.di.component.MovieComponent;
import com.example.user.firebase.di.module.AppModule;
import com.example.user.firebase.di.module.MovieModule;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by singh on 12/21/17.
 */

public class FirebaseApplication extends Application {

    AppComponent appComponent;
    LoginComponent loginComponent;
    MovieComponent movieComponent;
    private FirebaseDatabase firebaseDatabase;
    private FirebaseAuth firebaseAuth;


    @Override
    public void onCreate() {
        super.onCreate();

        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();

        AppModule appModule = new AppModule(firebaseDatabase, firebaseAuth);
        appComponent = DaggerAppComponent.builder()
                .appModule(appModule)
                .build();

    }

    public static FirebaseApplication get(Context context) {
        return (FirebaseApplication) context.getApplicationContext();
    }

    public MovieComponent getMovieComponent() {
        movieComponent = appComponent.add(new MovieModule());
        return movieComponent;

    }


    public void clearMovieComponent() {
        movieComponent = null;
    }

}
