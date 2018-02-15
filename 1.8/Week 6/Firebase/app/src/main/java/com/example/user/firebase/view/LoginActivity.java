package com.example.user.firebase.view;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.firebase.utils.LoginAuthenticator;
import com.example.user.firebase.R;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity implements LoginAuthenticator.onLoginInteraction {

    private static final String TAG = LoginActivity.class.getSimpleName();

    private EditText etEmail;
    private EditText etPassword;
    String email, password;

    private FirebaseUser currentUser;
    private LoginAuthenticator loginAuthenticator;
    private String articleId;

    public static final String ARTICLE_ACT= "Article";
    public static final String DATA_ACT = "Data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginAuthenticator = new LoginAuthenticator(this);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);


        articleId = getIntent().getStringExtra("articleId");

    }

    @Override
    protected void onStart() {
        super.onStart();
        currentUser = loginAuthenticator.checkSession();
        if (currentUser != null) {

            if (articleId != null) {

                goToActivity(ARTICLE_ACT);
            } else {
                goToActivity(DATA_ACT);
            }


        }
    }

    private void goToActivity(String className) {

        Class c = null;
        Intent intent = new Intent();

        switch (className) {

            case ARTICLE_ACT:
                c = ArticleActivity.class;
                intent.putExtra("articleID", articleId);
                break;

            case DATA_ACT:
                c = DataActivity.class;
                break;
        }
        ComponentName componentName = new ComponentName(getApplicationContext(), c);
        intent.setComponent(componentName);

        startActivity(intent);

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
