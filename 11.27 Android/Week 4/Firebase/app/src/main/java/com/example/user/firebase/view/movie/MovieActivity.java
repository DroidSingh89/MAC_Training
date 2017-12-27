package com.example.user.firebase.view.movie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.user.firebase.R;
import com.example.user.firebase.model.Movie;
import com.example.user.firebase.utils.FireBaseApplication;
import com.example.user.firebase.view.login.LoginActivity;
import com.example.user.firebase.view.login.LoginAuthenticator;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;

import javax.inject.Inject;


public class MovieActivity extends AppCompatActivity implements MovieContract.View{

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

        setupDaggerComponent();

        bindView();
    }

    private void setupDaggerComponent() {
        FireBaseApplication.get(this).getMovieComponent().inject(this);
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

    public void onFireBaseSignOut(View view) {

        moviePresenter.signOut();

    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void onSignOut(Boolean isSignedOut) {

        if (isSignedOut) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onMovieAdded(boolean isAdded) {

    }

    @Override
    public void onMovieListReceived(List<Movie> movies) {

    }
}
