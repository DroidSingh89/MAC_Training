package com.example.user.firebase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class PeopleActivity extends AppCompatActivity {

    private UserAuthenticator userAuthenticator;
    private FirebaseDataManager firebaseDataManager;
    private EditText etSimpleData;
    private TextView tvSimpleData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people);

        userAuthenticator = new UserAuthenticator();
        firebaseDataManager = new FirebaseDataManager();

        etSimpleData = findViewById(R.id.etSimpleData);
        tvSimpleData = findViewById(R.id.tvSimpleData);


    }

    public void onSimpleData(View view) {
        firebaseDataManager.uploadSimpleData(etSimpleData.getText().toString());

    }

    public void onPersonUpload(View view) {
    }

    public void onDownloadPeople(View view) {
    }

    public void onSignOut(View view) {
        userAuthenticator.signOut();
        finish();

    }

    public void onDownloadSimpleData(View view) {

        firebaseDataManager.downloadSimpleData(new FirebaseDataManager.SimpleCallback() {
            @Override
            public void onSimpleDataChange(String simpleData) {
                tvSimpleData.setText(simpleData);
            }
        });
    }
}
