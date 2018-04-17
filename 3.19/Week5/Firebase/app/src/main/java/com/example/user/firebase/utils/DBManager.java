package com.example.user.firebase.utils;

import android.support.annotation.NonNull;
import android.text.method.MovementMethod;
import android.util.Log;
import android.widget.TextView;

import com.example.user.firebase.model.Movie;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.content.ContentValues.TAG;

public class DBManager {


    private final FirebaseDatabase database;
    private final DatabaseReference userRef;
    private final DatabaseReference profileRef;
    private final DatabaseReference msgRef;

    TextView textView;
    private final DatabaseReference movieRef;

    public DBManager(TextView textView) {
        this.textView = textView;
        database = FirebaseDatabase.getInstance();

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        userRef = database.getReference(user.getUid());

        //profile reference
        profileRef = userRef.child("profile");

        //messages
        msgRef = userRef.child("messages");

        //movies
        movieRef = userRef.child("movies");

    }

    public void save(String data) {

        Map<String, String> profileMap = new HashMap<>();
        profileMap.put("Name", "John Doe");
        profileMap.put("Age", "Some message");

        //saving the profile
        profileRef.setValue(profileMap);

        //saving messages
        msgRef.setValue(data);
    }

    public void saveMovie(Movie movie) {

        movieRef.push().setValue(movie);

    }

    public void retrieve() {

        // Read from the database
        msgRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Value is: " + value);
                textView.setText(value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        //Reading the profile
        profileRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Map<String, String> profMap = (Map<String, String>) dataSnapshot.getValue();

                Log.d(TAG, "onDataChange: " + profMap.get("Name"));

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void retrieveMovies(){

        movieRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //one way to get the list of movies
                Map<String, Movie> moviesMaps= (Map<String, Movie>) dataSnapshot.getValue();
                List<Movie> movies = new ArrayList<>(moviesMaps.values());



//                Another way to get the list of movies
//                List<Movie> movies = new ArrayList<>();
//
//                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                    Movie movie = snapshot.getValue(Movie.class);
//                    movies.add(movie);
//                }

                Log.d(TAG, "onDataChange: " + movies);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



    }
}
