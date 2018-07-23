package com.example.user.firebase.manager;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.user.firebase.model.Person;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static android.content.ContentValues.TAG;

public class RemoteDatabaseManager {


    private static RemoteDatabaseManager instance = null;
    FirebaseDatabase database;

    private RemoteDatabaseManager() {

    }
    public static RemoteDatabaseManager getInstance() {

        if (instance == null) {
            instance = new RemoteDatabaseManager();
        }

        return instance;
    }

    public void uploadData(String data) {
        database = FirebaseDatabase.getInstance();

//        create a reference
        DatabaseReference homeReference = database.getReference("home");
        homeReference.setValue(data);


    }

    public void uploadPerson(Person person) {
        database = FirebaseDatabase.getInstance();

//        create a references for person
        DatabaseReference personRef = database.getReference("people");

        personRef.push().setValue(person);//push creates a new reference


    }

    public void readPeople() {

        database = FirebaseDatabase.getInstance();

        DatabaseReference personRef = database.getReference("people");

        personRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Person person = snapshot.getValue(Person.class);
                    Log.d(TAG, "onDataChange: " + person.getFirstName());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }


}
