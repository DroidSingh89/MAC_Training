package com.example.user.firebase_uu;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MovieActivity extends AppCompatActivity {

    private static final String TAG = "MovieActivityTag";
    private FirebaseDatabase database;
    private DatabaseReference myMovieRef;
    private String movieName, movieYear, movieDirector;
    private EditText etMovieName;
    private EditText etMovieYear;
    private EditText etMovieDirector;
    private FirebaseUser user;
    private MyReceiver myReceiver;
    private String customdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        customdata = getIntent().getStringExtra("customdata");
        if(customdata!=null)
        Toast.makeText(this, customdata, Toast.LENGTH_SHORT).show();


        // Write a message to the database
        database = FirebaseDatabase.getInstance();
        myMovieRef = database.getReference("movies");

        //bind the views
        etMovieName = findViewById(R.id.etMovieName);
        etMovieYear = findViewById(R.id.etMovieYear);
        etMovieDirector = findViewById(R.id.etMovieDirector);

        //get firebase user
        user = FirebaseAuth.getInstance().getCurrentUser();

    }

    public void onAddMovie(View view) {
        Movie movie = getMovie();
        myMovieRef
                .child(user.getUid())
                .child("favoritemovies")
                .push()
                .setValue(movie)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        Toast.makeText(MovieActivity.this, "Movie added", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        Toast.makeText(MovieActivity.this, "Movie not added", Toast.LENGTH_SHORT).show();
                    }
                });

    }

    @NonNull
    private Movie getMovie() {
        movieName = etMovieName.getText().toString();
        movieYear = etMovieYear.getText().toString();
        movieDirector = etMovieDirector.getText().toString();
        return new Movie(movieName, movieDirector, movieYear);
    }

    public void onGetMovies(View view) {
        // Read from the database
        myMovieRef
                .child(user.getUid())
                .child("favoritemovies")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            Movie movie = snapshot.getValue(Movie.class);
                            Log.d(TAG, "onDataChange: " + movie.getName());
                        }

                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Log.w(TAG, "Failed to read value.", error.toException());
                    }
                });


    }

    public class MyReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(final Context context, Intent intent) {
            if (!isFinishing()) {

                AlertDialog alertDialog = new AlertDialog.Builder(context)
                        .setMessage("Schedule job")
                        .setMessage("Received an update to do " + intent.getStringExtra("customdata") + ". Do you want to schedule the job?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(context, "Scheduled", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(context, "Not Scheduled", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .create();
                alertDialog.show();
            }


        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        myReceiver = new MyReceiver();
        IntentFilter intentFilter = new IntentFilter("openDialog");

        registerReceiver(myReceiver, intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(myReceiver);
    }
}
