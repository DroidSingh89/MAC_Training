package com.example.user.firebase.view;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.firebase.R;
import com.example.user.firebase.model.Movie;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MovieActivity extends AppCompatActivity {


    private static final String TAG = "MovieActivityTag";
    private String uid;
    private FirebaseDatabase database;
    private DatabaseReference myRefUsers;
    private EditText etMovieName;
    private EditText etMovieYear;
    private EditText etMovieDirector;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        etMovieName = (EditText) findViewById(R.id.etMovieName);
        etMovieYear = (EditText) findViewById(R.id.etMovieYear);
        etMovieDirector = (EditText) findViewById(R.id.etMovieDirector);


        user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {

            // The user's ID, unique to the Firebase project. Do NOT use this value to
            // authenticate with your backend server, if you have one. Use
            // FirebaseUser.getToken() instead.
            uid = user.getUid();
        }

        database = FirebaseDatabase.getInstance();
        myRefUsers = database.getReference("users");

    }

    public void addMovie(View view) {

        String movieName = etMovieName.getText().toString();
        String movieDirector = etMovieDirector.getText().toString();
        String movieYear = etMovieYear.getText().toString();

        Movie movie = new Movie(movieName, movieDirector, movieYear);

        myRefUsers
                .child(uid)
                .child("movies")
                .push()
                .setValue(movie)
                .addOnSuccessListener(this, new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(MovieActivity.this, "Movie was added", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(this, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MovieActivity.this, "Not added, check logs", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "onFailure: " + e.toString());
                    }
                });


    }

    public void signOut(View view) {

        FirebaseAuth.getInstance().signOut();

        user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {

            Toast.makeText(this, "User not signed out", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

    }

    public void getMovies(View view) {

        final List<Movie> movies = new ArrayList<>();

        myRefUsers = database.getReference("users");
        // Read from the database
        myRefUsers.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                boolean hasChildren = dataSnapshot
                        .child(uid)
                        .child("movies")
                        .hasChildren();

                if (hasChildren) {
                    Log.d(TAG, "onDataChange: " +
                            dataSnapshot.getChildrenCount());


                    for (DataSnapshot snapshot : dataSnapshot
                            .child(uid)
                            .child("movies")
                            .getChildren()) {
                        Movie movie = snapshot.getValue(Movie.class);


                        Log.d(TAG, "onDataChange: " + movie.toString());
                        movies.add(movie);

                    }

                }


            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        Log.d(TAG, "getMovies: "+ movies.size());

    }
}
