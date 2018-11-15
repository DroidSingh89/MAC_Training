package com.example.user.firebase;

import android.support.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FirebaseDataManager {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;


    public FirebaseDataManager() {
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("simpleData");
    }


    public void uploadSimpleData(String simpleData) {
        databaseReference.setValue(simpleData);

    }

    public void downloadSimpleData(final SimpleCallback simpleCallback) {

        databaseReference.addValueEventListener(new ValueEventListener() {
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

    interface SimpleCallback{
        void onSimpleDataChange(String simpleData);
    }

}
