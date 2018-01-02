package com.example.user.firebase.data.firebase;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.user.firebase.model.Movie;
import com.example.user.firebase.utils.BasePresenter;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
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
    private FirebaseDatabase firebaseDatabase;
    private OnDataBaseInteraction onDataBaseInteraction;

    public static class Reference {
        public static final String MOVIE = "movie";
        public static final String USER = "user";
    }

    public FireBaseWrapper(FirebaseDatabase firebaseDatabase) {
        this.firebaseDatabase = firebaseDatabase;
        initReferences();
    }

    private void initReferences() {
        movieRef = firebaseDatabase.getReference(Reference.MOVIE);
    }

    public void attach(Object object) {
        if (object instanceof BasePresenter)
            onDataBaseInteraction = (OnDataBaseInteraction) object;
    }

    public void saveMovie(Movie movie) {
        movieRef.push().setValue(movie).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                onDataBaseInteraction.onMovieAdded(true);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                onDataBaseInteraction.onMovieAdded(false);
            }
        });


    }

    public void getMovieList() {
        final List<Movie> movieList = new ArrayList<>();

        movieRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren())
                    movieList.add(snapshot.getValue(Movie.class));

                onDataBaseInteraction.onMoviesReceived(movieList);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    public interface OnDataBaseInteraction {

        void onMovieAdded(boolean isAdded);

        void onMoviesReceived(List<Movie> movies);
    }

}
