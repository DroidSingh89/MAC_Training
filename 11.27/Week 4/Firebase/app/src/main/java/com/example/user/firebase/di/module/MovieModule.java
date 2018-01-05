package com.example.user.firebase.di.module;

import com.example.user.firebase.data.firebase.FireBaseWrapper;
import com.example.user.firebase.model.Movie;
import com.example.user.firebase.view.login.LoginAuthenticator;
import com.example.user.firebase.view.movie.MoviePresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by singh on 12/21/17.
 */

@Module
public class MovieModule {

    @Provides
    MoviePresenter providesMoviePresenter(FireBaseWrapper fireBaseWrapper, LoginAuthenticator loginAuthenticator) {
        return new MoviePresenter(fireBaseWrapper, loginAuthenticator);
    }
}
