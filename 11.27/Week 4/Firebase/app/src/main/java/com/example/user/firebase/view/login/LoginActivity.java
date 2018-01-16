package com.example.user.firebase.view.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.firebase.R;
import com.example.user.firebase.utils.FireBaseApplication;
import com.example.user.firebase.view.movie.MovieActivity;
import com.example.user.firebase.view.notification.NotificationActivity;


import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity
        implements LoginContract.View {

    @BindView(R.id.etEmail)
    EditText etEmail;
    @BindView(R.id.etPassword)
    EditText etPassword;

    private String email;
    private String password;

    @Inject
    LoginPresenter presenter;

    public static final String TAG = "LoginActivityTag";
    private boolean isNotificationReceived;
    private String articleName;
    private String articleId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        setupDaggerComponent();

        
        //handle notification
        articleName = getIntent().getStringExtra("name");
        articleId = getIntent().getStringExtra("id");

        if (articleName != null) {
            isNotificationReceived = true;
        }

    }

    private void startNotificationActivity(String articleName, String articleId) {
        Intent intent = new Intent(this, NotificationActivity.class);
        intent.putExtra("name", articleName);
        intent.putExtra("id", articleId);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
        presenter.attachView(this);
        presenter.checkSession();

    }

    private void setupDaggerComponent() {
        FireBaseApplication
                .get(this)
                .getLoginComponent(this)
                .inject(this);
    }

    public void onFireBaseSignUp(View view) {

        getCredentials();
        presenter.createUser(email, password);

    }

    private void getCredentials() {
        email = etEmail.getText().toString();
        password = etPassword.getText().toString();
    }

    public void onFireBaseSignIn(View view) {
        getCredentials();
        presenter.validateUser(email, password);

    }

    @Override
    public void showError(String error) {
        showToast(error);
    }

    @Override
    public void onSignOut(Boolean isSignedOut) {

    }

    @Override
    public void onUserCreation(boolean isCreated) {

        Log.d(TAG, "onUserCreation: " + isCreated);

        if (isCreated)
            showToast("User created, please sign in");
        else
            showToast("User not created");
    }

    @Override
    public void onUserValidation(boolean isValid) {

        Log.d(TAG, "onUserValidation: " + isValid);
        if (isValid) {

            showToast("Signed In");
            startMovieActivity();
        } else
            showToast("Sign in failed");
    }

    @Override
    public void isSessionValid(boolean isValid) {
        if (isValid) {
            if (isNotificationReceived) {
                startNotificationActivity(articleName, articleId);
            }
            else {
                startMovieActivity();
            }
        }

    }

    private void startMovieActivity() {
        Intent intent = new Intent(getApplicationContext(), MovieActivity.class);
        startActivity(intent);
    }

    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.detachView();
    }
}
