package com.example.user.firebase.view.movie;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;


import com.example.user.firebase.model.Movie;
import com.example.user.firebase.managers.AuthManager;
import com.example.user.firebase.managers.DBManager;
import com.example.user.firebase.R;
import com.google.firebase.messaging.FirebaseMessaging;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieActivity extends AppCompatActivity implements AuthManager.ISignOutInteraction {

    @BindView(R.id.etMovieName)
    EditText etMovieName;
    @BindView(R.id.etMovieGenre)
    EditText etMovieGenre;
    @BindView(R.id.lvMovies)
    ListView lvMovies;
    private TextView tvEmail;
    private AuthManager authManager;
    private EditText etData;
    private DBManager dbManager;
    private TextView tvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        ButterKnife.bind(this);
        bindViews();
        injectManagers();

        FirebaseMessaging firebaseMessaging = FirebaseMessaging.getInstance();
        firebaseMessaging.subscribeToTopic("sometopic");


        tvEmail.setText(authManager.getUser().getEmail());
    }

    private void injectManagers() {
        authManager = AuthManager.getDefault(this);
        dbManager = new DBManager();

    }

    private void bindViews() {
        tvEmail = findViewById(R.id.tvEmail);
        etData = findViewById(R.id.etData);
        tvData = findViewById(R.id.tvData);
    }

    public void onSignOut(View view) {
        authManager.signOut();
    }

    @Override
    public void onSignOut(boolean isSignedOut) {
        finish();
    }

    public void onSaveToFB(View view) {

        dbManager.save(etData.getText().toString());
    }

    public void onRetrieveFromFB(View view) {

        dbManager.retrieve();
    }

    public void onSaveMovie(View view) {

        dbManager.saveMovie(new Movie(etMovieName.getText().toString()
                , etMovieGenre.getText().toString()));

    }

    public void onMoviesReceived(View view) {
        dbManager.retrieveMovies();
    }
}
