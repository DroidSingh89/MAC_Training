package com.example.user.firebase.view.movie;

import com.example.user.firebase.model.Movie;
import com.example.user.firebase.utils.BasePresenter;
import com.example.user.firebase.utils.BaseView;

import java.util.List;

/**
 * Created by singh on 12/21/17.
 */

public interface MovieContract {

    interface View extends BaseView {

        void onMovieAdded(boolean isAdded);

        void onMovieListReceived(List<Movie> movies);


    }

    interface Presenter extends BasePresenter<View> {

        void saveMovie(Movie movie);

        void getMovieList();


    }

}
