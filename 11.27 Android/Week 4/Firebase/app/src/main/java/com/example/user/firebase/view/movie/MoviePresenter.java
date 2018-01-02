package com.example.user.firebase.view.movie;

import com.example.user.firebase.data.firebase.FireBaseWrapper;
import com.example.user.firebase.model.Movie;
import com.example.user.firebase.view.login.LoginAuthenticator;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by singh on 12/21/17.
 */

public class MoviePresenter implements
        MovieContract.Presenter,
        LoginAuthenticator.OnSignOutInteraction,
        FireBaseWrapper.OnDataBaseInteraction {

    private MovieContract.View view;
    private FireBaseWrapper fireBaseWrapper;
    private LoginAuthenticator loginAuthenticator;


    public MoviePresenter(FireBaseWrapper fireBaseWrapper, LoginAuthenticator loginAuthenticator) {
        this.fireBaseWrapper = fireBaseWrapper;
        this.loginAuthenticator = loginAuthenticator;
        this.loginAuthenticator.attach(this);
        this.fireBaseWrapper.attach(this);
    }

    @Override
    public void attachView(MovieContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void signOut() {
        loginAuthenticator.signOut();
    }

    @Override
    public void saveMovie(Movie movie) {
        fireBaseWrapper.saveMovie(movie);
    }

    @Override
    public void getMovieList() {
        fireBaseWrapper.getMovieList();
    }


    @Override
    public void onSignOut(boolean isSignedOut) {
        view.onSignOut(isSignedOut);
    }

    @Override
    public void onMovieAdded(boolean isAdded) {
        view.onMovieAdded(isAdded);
    }

    @Override
    public void onMoviesReceived(List<Movie> movies) {
        view.onMovieListReceived(movies);
    }
}
