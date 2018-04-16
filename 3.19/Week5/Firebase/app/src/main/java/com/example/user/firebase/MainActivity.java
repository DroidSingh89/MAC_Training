package com.example.user.firebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.firebase.utils.AuthManager;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements AuthManager.ILoginInteraction{

    private EditText etEmail;
    private EditText etPassword;
    private String email;
    private String password;
    private AuthManager authManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
        authManager = AuthManager.getDefault(this);

        }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = authManager.getUser();
        if (user != null) {
            startSecondActivity();
        }


    }

    private void startSecondActivity() {
        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
        startActivity(intent);

    }

    public void onSignIn(View view) {
        getCredentials();

        authManager.signIn(email, password);

    }

    public void onRegister(View view) {
        getCredentials();
        authManager.register(email, password);

    }

    private void bindViews() {
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
    }

    private void getCredentials() {
        email = etEmail.getText().toString();
        password = etPassword.getText().toString();
    }

    @Override
    public void onLoginSuccess(FirebaseUser user) {

        Toast.makeText(this, "Welcome" + user.getEmail(), Toast.LENGTH_SHORT).show();
        startSecondActivity();
    }

    @Override
    public void onLoginError(String error) {

        Toast.makeText(this, "Login failed: " + error, Toast.LENGTH_SHORT).show();
    }

}
