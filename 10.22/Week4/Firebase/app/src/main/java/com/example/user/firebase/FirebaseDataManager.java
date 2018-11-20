package com.example.user.firebase;

import android.support.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseDataManager {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference simpleReference;
    private final DatabaseReference peopleReference;



    public FirebaseDataManager() {
        firebaseDatabase = FirebaseDatabase.getInstance();
        simpleReference = firebaseDatabase.getReference("simpleData");
        peopleReference = firebaseDatabase.getReference("people");

    }


    public void uploadSimpleData(String simpleData) {
        simpleReference.setValue(simpleData);

    }

    public void downloadSimpleData(final SimpleCallback simpleCallback) {

        simpleReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String simpleData = dataSnapshot.getValue(String.class);
                simpleCallback.onSimpleDataChange(simpleData);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    public void uploadPerson(Person person) {

        peopleReference
                .push()
                .setValue(person);
    }

    public void downloadPeople(final PeopleCallback callback) {

        peopleReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                List<Person> people = new ArrayList<>();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    people.add(snapshot.getValue(Person.class));
                }

                callback.onPeopleDataChange(people);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    interface SimpleCallback{
        void onSimpleDataChange(String simpleData);
    }

    interface PeopleCallback {

        void onPeopleDataChange(List<Person> personList);
    }

}
