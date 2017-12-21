package com.example.user.firebase.data.firebase;

import android.util.Log;

import com.example.user.firebase.model.Movie;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by singh on 12/21/17.
 */

public class FireBaseWrapper {


    private static final String TAG = "FireBaseWrapperTag";
    private DatabaseReference movieRef;

    public static class Reference {

        public static final String MOVIE = "movie";

        public static final String USER = "user";
    }

    FirebaseDatabase firebaseDatabase;


    DatabaseReference myRefChanged;
    DatabaseReference myRef;

    public FireBaseWrapper(FirebaseDatabase firebaseDatabase) {
        this.firebaseDatabase = firebaseDatabase;
        initReferences();
    }

    private void initReferences() {
//        used to save simple data on firebase db
//        myRef = firebaseDatabase.getReference("myRef");
//        myRefChanged = firebaseDatabase.getReference("myRefChanged");

        movieRef = firebaseDatabase.getReference(Reference.MOVIE);
    }

    public void saveSimpleData(String message) {

        myRefChanged.child("myChildRef").setValue(message);


    }

    public void readSimpleData() {

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String simpleData = dataSnapshot.getValue(String.class);
                Log.d(TAG, "onDataChange: " + simpleData);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    public void saveMovie(Movie movie) {

        movieRef.push().setValue(movie);

    }

    public void getMovieList() {
        final List<Movie> movieList = new ArrayList<>();

        movieRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot snapshot : dataSnapshot.getChildren())
                    movieList.add(snapshot.getValue(Movie.class));

                Log.d(TAG, "onDataChange: " + movieList.toString());


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
}
