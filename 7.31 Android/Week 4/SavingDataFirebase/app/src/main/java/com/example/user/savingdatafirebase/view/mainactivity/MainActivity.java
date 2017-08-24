package com.example.user.savingdatafirebase.view.mainactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.user.savingdatafirebase.R;
import com.example.user.savingdatafirebase.injection.mainactivity.DaggerMainActivityComponent;
import com.example.user.savingdatafirebase.injection.mainactivity.MainActivityModule;
import com.example.user.savingdatafirebase.model.Movie;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View {


    private static final String TAG = "MainActivityTag";
    @Inject
    MainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupDaggerComponent();

        presenter.init();
        presenter.attachView(this);
        presenter.saveDataToCloud("John doe");
        presenter.readFromCloud();
    }

    private void setupDaggerComponent() {
        DaggerMainActivityComponent.create().insert(this);

    }


    @Override
    public void showError(String s) {
    }

    @Override
    public void onDataSaved(boolean isSaved) {


        Log.d(TAG, "onDataSaved: " + isSaved);
    }

    @Override
    public void updateTextView(String s) {
        Log.d(TAG, "updateTextView: " + s);
    }

    @Override
    public void updateMovieList(List<Movie> movieList) {

        Log.d(TAG, "updateMovieList: " + movieList.toString());


//        for(Movie movie: movieList) {
//            Log.d(TAG, "updateMovieList: " + movie.toString());
//        }

    }

    public void updateFirebaseDb(View view) {

        switch (view.getId()){

            case R.id.btnPushMovie:

                Movie movie = new Movie("Avengers", "sdfsdf",2015);

                presenter.pushMovieToDb(movie);

                break;

            case R.id.btnGetMovies:

                presenter.getMovies();

                break;
        }


    }
}
