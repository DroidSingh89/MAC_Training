package com.example.user.firebase.view.movie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.user.firebase.R;
import com.example.user.firebase.data.firebase.FireBaseWrapper;
import com.example.user.firebase.model.Movie;
import com.example.user.firebase.utils.FirebaseApplication;
import com.google.firebase.database.FirebaseDatabase;

import javax.inject.Inject;

public class MovieActivity extends AppCompatActivity {

    @Inject
    MoviePresenter moviePresenter;

    private EditText etMovieName;
    private EditText etMovieYear;
    private EditText etMovieGenre;
    private EditText etMovieDirector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        FirebaseApplication.get(this).getMovieComponent().inject(this);

        bindView();
    }

    private void bindView() {
        etMovieName = findViewById(R.id.etMovieName);
        etMovieYear = findViewById(R.id.etMovieYear);
        etMovieGenre = findViewById(R.id.etMovieGenre);
        etMovieDirector = findViewById(R.id.etMovieDirector);
    }

    public void addMovieToFB(View view) {

        Movie movie = new Movie(etMovieName.getText().toString(),
                etMovieYear.getText().toString(),
                etMovieGenre.getText().toString(),
                etMovieDirector.getText().toString());

        moviePresenter.saveMovie(movie);

    }

    public void getMovies(View view) {

        moviePresenter.getMovieList();
    }
}
