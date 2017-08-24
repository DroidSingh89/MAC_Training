package com.example.user.savingdatafirebase.view.mainactivity;

import com.example.user.savingdatafirebase.BasePresenter;
import com.example.user.savingdatafirebase.BaseView;
import com.example.user.savingdatafirebase.model.Movie;

import java.util.List;

/**
 * Created by singh on 8/22/17.
 */

public interface MainActivityContract {


    interface View extends BaseView{


        void onDataSaved(boolean isSaved);
        void updateTextView(String s);

        void updateMovieList(List<Movie> movieList);

    }

    interface Presenter extends BasePresenter<View>{

        void init();
        void saveDataToCloud(String s);
        void readFromCloud();
        void pushMovieToDb(Movie movie);
        void getMovies();

    }
}
