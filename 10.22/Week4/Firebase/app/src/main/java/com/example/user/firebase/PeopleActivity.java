package com.example.user.firebase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class PeopleActivity extends AppCompatActivity {

    private UserAuthenticator userAuthenticator;
    private FirebaseDataManager firebaseDataManager;
    private EditText etSimpleData;
    private TextView tvSimpleData;
    private EditText etPersonName;
    private EditText etPersonAge;
    private EditText etPersonGender;

    private static final String TAG = PeopleActivity.class.getSimpleName()+ "_TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people);

        userAuthenticator = new UserAuthenticator();
        firebaseDataManager = new FirebaseDataManager();

        etSimpleData = findViewById(R.id.etSimpleData);
        tvSimpleData = findViewById(R.id.tvSimpleData);

        etPersonName = findViewById(R.id.etPersonName);
        etPersonAge = findViewById(R.id.etPersonAge);
        etPersonGender = findViewById(R.id.etPersonGender);


    }

    public void onSimpleData(View view) {
        firebaseDataManager.uploadSimpleData(etSimpleData.getText().toString());

    }

    public Person getPerson() {
        return new Person(etPersonName.getText().toString(),
                etPersonAge.getText().toString(),
                etPersonGender.getText().toString());
    }

    public void onPersonUpload(View view) {

        firebaseDataManager.uploadPerson(getPerson());

    }

    public void onDownloadPeople(View view) {

        firebaseDataManager.downloadPeople(new FirebaseDataManager.PeopleCallback() {
            @Override
            public void onPeopleDataChange(List<Person> personList) {
                for (Person person : personList) {
                    Log.d(TAG, "onPeopleDataChange: "+ person.toString());
                }
            }
        });
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
