package com.example.user.firebaseauthandnotification;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Main2Activity extends AppCompatActivity {

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        auth= FirebaseAuth.getInstance();

    }

    public void signoutFirebase(View view) {

        auth.signOut();

        if(auth.getCurrentUser()==null){
            Toast.makeText(this, "Signed out", Toast.LENGTH_SHORT).show();
            finish();
        }


    }
}
