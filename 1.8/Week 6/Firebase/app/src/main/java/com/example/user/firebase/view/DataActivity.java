package com.example.user.firebase.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.user.firebase.utils.FirebaseDB;
import com.example.user.firebase.utils.LoginAuthenticator;
import com.example.user.firebase.R;
import com.example.user.firebase.model.Movie;
import com.google.firebase.auth.FirebaseUser;

public class DataActivity extends AppCompatActivity implements LoginAuthenticator.onLoginInteraction {

    private LoginAuthenticator loginAuthenticator;
    private FirebaseDB firebaseDB;
    private EditText etSimpleData;
    private EditText etMovie;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        loginAuthenticator = new LoginAuthenticator(this);
        firebaseDB = new FirebaseDB();

        etSimpleData = findViewById(R.id.etSimpleData);
        etMovie = findViewById(R.id.etMovie);
    }

    public void onUserSignOut(View view) {

        loginAuthenticator.signOut();
        FirebaseUser firebaseUser = loginAuthenticator.getUser();
        if (firebaseUser == null) {
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);

        }
    }

    public void onSaveSimpleData(View view) {

        firebaseDB.saveSimpleData(etSimpleData.getText().toString());
    }

    @Override
    public void onUserCreation(FirebaseUser firebaseUser) {

    }

    @Override
    public void onUserAuthenticated(FirebaseUser firebaseUser) {

    }

    @Override
    public void onSignOut(boolean isSignedOut) {

    }

    public void onSaveMovie(View view) {

        firebaseDB.saveMovie(getMovieFromText(
                etMovie.getText().toString().split(",")));

    }



    public Movie getMovieFromText(String[] movieString) {
        return new Movie(
                movieString[0],
                movieString[1],
                movieString[2],
                movieString[3],
                movieString[4]);

    }


    public void onMoviesReceived(View view) {

        firebaseDB.getMovies();

    }
}
