package com.example.user.activitylifecycleandcpnfigchanges;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.user.activitylifecycleandcpnfigchanges.model.Person;
import com.example.user.activitylifecycleandcpnfigchanges.utils.Constants;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = MainActivity.class.getSimpleName();
    private EditText etMain;
    private TextView tvMain;
    private EditText etPersonName;
    private EditText etPersonAge;
    private EditText etPersonGender;
    private Person person;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");
        bindViews();

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d(TAG, "onConfigurationChanged: ");
    }

    private void bindViews() {
        etMain = findViewById(R.id.etMain);
        tvMain = findViewById(R.id.tvMain);

        etPersonName = findViewById(R.id.etPersonName);
        etPersonAge = findViewById(R.id.etPersonAge);
        etPersonGender = findViewById(R.id.etPersonGender);
    }

    //    lifecycle methods
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }

    public void onSecondActivity(View view) {

//        go to second activity
        startSecondActivity(Constants.ACTION.TEXTVIEW);

    }

    public void onUpdateTextView(View view) {

        tvMain.setText(getTextMain());
    }

    @NonNull
    private String getTextMain() {
        return etMain.getText().toString();
    }


//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//        Log.d(TAG, "onSaveInstanceState: ");
//
//        String data = tvMain.getText().toString();
//        outState.putString(Constants.KEYS.TVMAIN, data);
//    }
//
//    @Override
//    protected void onRestoreInstanceState(Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//        Log.d(TAG, "onRestoreInstanceState: ");
//
//        String retrievedText = savedInstanceState.getString(Constants.KEYS.TVMAIN);
//        tvMain.setText(retrievedText);
//
//    }


    public void onSendPerson(View view) {

        String personName = etPersonName.getText().toString();
        String personAge = etPersonAge.getText().toString();
        String personGender = etPersonGender.getText().toString();

        person = new Person(personName, personAge, personGender);


//        startSecondActivity(Constants.ACTION.P_SERIAL);
        startSecondActivity(Constants.ACTION.P_PARCEL);



    }

    public void startSecondActivity(String action) {

        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
        intent.setAction(action);
        switch (action) {

            case Constants.ACTION.TEXTVIEW:
                intent.putExtra(Constants.KEYS.TVMAIN, getTextMain());
                break;

            case Constants.ACTION.P_PARCEL:
                intent.putExtra(Constants.EXTRAS.PERSON, person);
                break;

            case Constants.ACTION.P_SERIAL:
                intent.putExtra(Constants.EXTRAS.PERSON, person);
        }
        startActivity(intent);
    }


}
