package com.example.user.firebase_uu;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivityTag";
    private FirebaseAuth mAuth;
    EditText etEmail;
    EditText etPassword;
    String email, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);

        String customData = getIntent().getStringExtra("Custom1");



        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            Intent intent = new Intent(this, MovieActivity.class);

            if(customData!=null){
            intent.putExtra("customdata", customData);
            }
            startActivity(intent);
        }

    }

    public void onSignIn(View view) {
        getUserCredentials();
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user, 1);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null, 1);
                        }

                        // ...
                    }
                });


    }

    public void onSignUp(View view) {
        getUserCredentials();

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user, 2);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null, 2);
                        }

                        // ...
                    }
                });

    }

    private void updateUI(FirebaseUser user, int statusCode) {

        String message;

        if (statusCode == 2) {

            if (user != null) {
                message = "New account for " + user.getEmail() + " created";
            } else {
                message = "Account creation failed";
            }

        } else if (user != null) {
            message = "User signed in successfully";
        } else {
            message = "Sign in failed";
        }


        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

        if (statusCode == 1 && user != null) {
            Intent intent = new Intent(this, MovieActivity.class);
            startActivity(intent);
        }


    }

    private void getUserCredentials() {
        email = etEmail.getText().toString();
        password = etPassword.getText().toString();
    }
}
