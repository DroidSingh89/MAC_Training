package com.example.user.firebase2;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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
    private EditText etName;
    private EditText etDirector;
    private EditText etProducer;
    FirebaseUser user;
    private DatabaseReference movieRef;
    private FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);


        user = FirebaseAuth.getInstance().getCurrentUser();

        etName = (EditText) findViewById(R.id.etMovieName);
        etDirector = (EditText) findViewById(R.id.etMovieDirector);
        etProducer = (EditText) findViewById(R.id.etMovieProducer);

        database = FirebaseDatabase.getInstance();
        movieRef = database.getReference("movies");


    }


    public void addMovie(View view) {
        String name, producer, director;

        name = etName.getText().toString();
        producer = etProducer.getText().toString();
        director = etDirector.getText().toString();
        Movie movie = new Movie(name, director, producer);

        /// Write a message to the database


        movieRef.child(user.getUid())
                .push()
                .setValue(movie)
                .addOnSuccessListener(this, new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(MovieActivity.this, "Movie saved", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(this, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MovieActivity.this, "Movie not saved", Toast.LENGTH_SHORT).show();
                    }
                });


    }

    public void getMovies(View view) {
        final List<Movie> movies = new ArrayList<>();

        movieRef.child(user.getUid())
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        boolean hasMovies = dataSnapshot.hasChildren();
                        Log.d(TAG, "onDataChange: " + hasMovies);

                        if (hasMovies) {
                            Log.d(TAG, "onDataChange: Movies count" + dataSnapshot.getChildrenCount());
                            movies.clear();
                            for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                                Movie movie = snapshot.getValue(Movie.class);
                                movies.add(movie);
                            }
                        }


                        Log.d(TAG, "getMovies: " + movies.toString());

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                        Log.d(TAG, "onCancelled: " + databaseError.getMessage());
                    }
                });

    }
}
