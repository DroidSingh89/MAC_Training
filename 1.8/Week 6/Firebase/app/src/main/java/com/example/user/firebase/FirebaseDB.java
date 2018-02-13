package com.example.user.firebase;

import android.util.Log;

import com.example.user.firebase.model.Movie;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static android.content.ContentValues.TAG;

/**
 * Created by singh on 2/13/18.
 */

public class FirebaseDB {

    private FirebaseDatabase database;
    private DatabaseReference mySimpleRef;
    private DatabaseReference myMovieRef;

    public FirebaseDB() {
        database = FirebaseDatabase.getInstance();
        mySimpleRef = database.getReference("defaultReference");
        myMovieRef = database.getReference("movies");
    }


    public void saveSimpleData(String data) {


        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

        String uuid = firebaseUser.getEmail();
        mySimpleRef.child(uuid.substring(0,uuid.length()-4)).child(getRandomChild()).child("common").push().setValue(data);
    }

    public String getRandomChild(){
        return String.valueOf(new Random().nextInt(100));
    }

    public void saveMovie(Movie movie) {

        myMovieRef.push().setValue(movie);
    }

    public void getMovies() {



        myMovieRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                List<Movie> movieList = new ArrayList<>();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Movie movie ;
                    movie =  snapshot.getValue(Movie.class);
                    movieList.add(movie);
                }

                Log.d(FirebaseDB.class.getSimpleName(), "onDataChange: " + movieList.toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

}
