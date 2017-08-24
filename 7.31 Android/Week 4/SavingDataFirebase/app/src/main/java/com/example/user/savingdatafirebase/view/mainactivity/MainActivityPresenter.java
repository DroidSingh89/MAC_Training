package com.example.user.savingdatafirebase.view.mainactivity;

import android.util.Log;

import com.example.user.savingdatafirebase.model.Movie;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by singh on 8/22/17.
 */

public class MainActivityPresenter implements MainActivityContract.Presenter {

    private static final String TAG = "MainPresenterTag";
    MainActivityContract.View view;
    FirebaseDatabase database;

    DatabaseReference myRef;

    @Override
    public void init() {
        database = FirebaseDatabase.getInstance();
    }

    @Override
    public void attachView(MainActivityContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {

        this.view = null;
    }

    // TODO: 8/22/17 implement firebase logic to save data
    @Override
    public void saveDataToCloud(String s) {

        // Write a message to the database
        myRef = database.getReference("message");

        myRef.setValue(s);

        //if saved to cloud
        view.onDataSaved(true);
    }

    @Override
    public void readFromCloud() {


        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.




                String value = dataSnapshot.getValue(String.class);
                view.updateTextView(value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }


    DatabaseReference movieReference;
    @Override
    public void pushMovieToDb(Movie movie) {

        movieReference = database.getReference("movies");


        //saving using default key method
        movieReference.push().setValue(movie);

        //making the key as movie.getName()
        movieReference.child(movie.getName()).setValue(movie);

        //adding multiple objects
        for (int i = 0; i < 5; i++) {
            movieReference.child("Movie " + i).setValue(movie);
        }



    }

    @Override
    public void getMovies() {

        final List<Movie> movieList = new ArrayList<>();
        movieReference = database.getReference("movies");

        movieReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                for(DataSnapshot snapshot: dataSnapshot.getChildren()){

                    Movie movie =  snapshot.getValue(Movie.class);
                    movieList.add(movie);


                }
                view.updateMovieList(movieList);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
}
