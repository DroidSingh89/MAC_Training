package com.example.user.firebase.view.movie;

import com.example.user.firebase.data.firebase.FireBaseWrapper;
import com.example.user.firebase.model.Movie;

/**
 * Created by singh on 12/21/17.
 */

public class MoviePresenter implements MovieContract.Presenter {

    MovieContract.View view;

    FireBaseWrapper fireBaseWrapper;

    public MoviePresenter(FireBaseWrapper fireBaseWrapper) {
        this.fireBaseWrapper = fireBaseWrapper;
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
    public void saveMovie(Movie movie) {

        fireBaseWrapper.saveMovie(movie);

    }

    @Override
    public void getMovieList() {

        fireBaseWrapper.getMovieList();


    }




}
