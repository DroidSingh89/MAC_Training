package com.example.user.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.user.firebase.utils.AuthManager;

public class SecondActivity extends AppCompatActivity implements AuthManager.ISignOutInteraction{

    private TextView tvEmail;
    private AuthManager authManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvEmail = findViewById(R.id.tvEmail);

        authManager = AuthManager.getDefault(this);
//        authManager.attach(this);
        tvEmail.setText(authManager.getUser().getEmail());
    }

    public void onSignOut(View view) {
        authManager.signOut();
    }

    @Override
    public void onSignOut(boolean isSignedOut) {
        finish();
    }
}
