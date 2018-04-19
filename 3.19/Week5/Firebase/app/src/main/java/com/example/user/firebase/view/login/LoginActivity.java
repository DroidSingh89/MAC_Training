package com.example.user.firebase.view.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.firebase.model.UserCredentials;
import com.example.user.firebase.view.movie.MovieActivity;
import com.example.user.firebase.view.post.PostActivity;
import com.example.user.firebase.managers.AuthManager;
import com.example.user.firebase.utils.IntentUtils;
import com.example.user.firebase.R;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {

    private static final String TAG = LoginActivity.class.getSimpleName() + "TAG";

    private EditText etEmail;
    private EditText etPassword;
    private String email;
    private String password;
    private LoginPresenter presenter;
    UserCredentials userCredentials;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bindViews();

        presenter = new LoginPresenter(AuthManager.getDefault(this));
        userCredentials = new UserCredentials(email, password);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.attachView(this);

        if (presenter.checkSession()) {

            Intent intent = getIntent();
            String postId = intent.getStringExtra("postId");
            if (postId != null) {

                IntentUtils.create(this)
                        .addComponent(PostActivity.class)
                        .putExtra("postID", postId)
                        .startActivity();

            } else startMovieActivity();

        }
    }

    private void startMovieActivity() {

        IntentUtils.create(this)
                .addComponent(MovieActivity.class)
                .startActivity();

    }

    public void onSignIn(View view) {
        getCredentials();

        presenter.signIn(userCredentials);

    }

    public void onRegister(View view) {
        getCredentials();
        presenter.register(userCredentials);

    }

    private void bindViews() {
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
    }

    private void getCredentials() {
        userCredentials.setUserEmail(etEmail.getText().toString());
        userCredentials.setPassword(etPassword.getText().toString());
    }

    @Override
    public void onLoginSuccess(FirebaseUser user) {
        Toast.makeText(this, "Welcome" + user.getEmail(), Toast.LENGTH_SHORT).show();
        startMovieActivity();
    }

    @Override
    public void onLoginFailure(String error) {
        Toast.makeText(this, "Login failed: " + error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError(String error) {

        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }


}
