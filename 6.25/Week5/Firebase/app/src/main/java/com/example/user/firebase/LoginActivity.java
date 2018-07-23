package com.example.user.firebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.firebase.manager.AuthManager;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity implements AuthManager.Callback{

    private EditText etEmail;
    private EditText etPassword;
    private AuthManager authManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);

        authManager = AuthManager.getInstance(this);

    }

    @Override
    protected void onStart() {
        super.onStart();

        if (authManager.checkSession()) {
            //redirect to different activity
            startHomeActivity();

        }
    }

    private void startHomeActivity() {
        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
        startActivity(intent);
    }

    public void onCreateAccount(View view) {

        authManager.createAccount(etEmail.getText().toString(), etPassword.getText().toString());

    }

    public void onSignIn(View view) {

        authManager.signIn(etEmail.getText().toString(), etPassword.getText().toString());

    }

    @Override
    public void onLoginResults(FirebaseUser user) {

        if (user != null) {
            startHomeActivity();
        }
        else Toast.makeText(this, "Login failed", Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onSignedOut() {


    }
}
