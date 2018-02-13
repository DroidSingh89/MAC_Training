package com.example.user.firebase;

import android.content.Intent;
import android.support.annotation.NonNull;
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

public class LoginActivity extends AppCompatActivity implements LoginAuthenticator.onLoginInteraction{

    private static final String TAG = LoginActivity.class.getSimpleName();

    private EditText etEmail;
    private EditText etPassword;
    String email, password;

    private FirebaseUser currentUser;
    private LoginAuthenticator loginAuthenticator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginAuthenticator = new LoginAuthenticator(this);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);


    }

    @Override
    protected void onStart() {
        super.onStart();
        currentUser = loginAuthenticator.checkSession();
        if (currentUser != null) {
            goToDataActivity();

        }
    }

    private void goToDataActivity() {
        Intent intent = new Intent(getApplicationContext(), DataActivity.class);
        startActivity(intent);
    }

    public void initCredentials() {
        email = etEmail.getText().toString();
        password = etPassword.getText().toString();
    }

    public void onAuthenticateUser(View view) {
        initCredentials();
        loginAuthenticator.authenticateUser(email, password);

    }

    public void onCreateUser(View view) {
        initCredentials();
        loginAuthenticator.createUser(email,password);
    }

    @Override
    public void onUserCreation(FirebaseUser firebaseUser) {
        if (firebaseUser != null) {
            Toast.makeText(this, "Welcome new user", Toast.LENGTH_SHORT).show();
            goToDataActivity();
        }
    }

    @Override
    public void onUserAuthenticated(FirebaseUser firebaseUser) {

        if (firebaseUser != null) {
            Toast.makeText(this, "Welcome back", Toast.LENGTH_SHORT).show();
            goToDataActivity();

        }
    }

    @Override
    public void onSignOut(boolean isSignedOut) {

        if (isSignedOut) {
            Toast.makeText(this, "User signed out", Toast.LENGTH_SHORT).show();
        }
    }
}
