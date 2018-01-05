package com.example.user.firebase.di.module;

import com.example.user.firebase.data.firebase.FireBaseWrapper;
import com.example.user.firebase.view.login.LoginAuthenticator;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import dagger.Module;
import dagger.Provides;

/**
 * Created by singh on 12/21/17.
 */

@Module
public class AppModule {

    FirebaseDatabase firebaseDatabase;
    FirebaseAuth firebaseAuth;

    public AppModule(FirebaseDatabase firebaseDatabase, FirebaseAuth firebaseAuth) {
        this.firebaseDatabase = firebaseDatabase;
        this.firebaseAuth = firebaseAuth;
    }


    @Provides
    LoginAuthenticator providesLoginAuthenticator() {
        return new LoginAuthenticator(firebaseAuth);
    }

    @Provides
    FireBaseWrapper providesFireBaseWrapper() {
        return new FireBaseWrapper(firebaseDatabase);
    }

}
