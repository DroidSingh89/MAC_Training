package com.example.user.activitylifecycleandintent;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.user.activitylifecycleandintent.model.Person;
import com.example.user.activitylifecycleandintent.model.PersonP;
import com.example.user.activitylifecycleandintent.utils.Constants;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String TEXTVIEW_KEY = "key";
    private EditText etMain;
    private TextView tvMain;
    private EditText etPersonName;
    private EditText etPersonAge;
    private EditText etPersonGender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");

        etMain = findViewById(R.id.etMain);
        tvMain = findViewById(R.id.tvMain);
        etPersonName = findViewById(R.id.etPersonName);
        etPersonAge = findViewById(R.id.etPersonAge);
        etPersonGender = findViewById(R.id.etPersonGender);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState: ");
        //save the data to the bundle
        outState.putString(TEXTVIEW_KEY, tvMain.getText().toString());

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "onRestoreInstanceState: ");
        String textViewData = savedInstanceState.getString(TEXTVIEW_KEY);
        tvMain.setText(textViewData);
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d(TAG, "onConfigurationChanged: ");
    }

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

    public void onButtonClicked(View view) {

        switch (view.getId()) {
            case R.id.btnPerson:

//                Create person object
                Person person = new Person(
                        etPersonName.getText().toString(),
                        etPersonAge.getText().toString(),
                        etPersonGender.getText().toString()
                );

                PersonP personP = new PersonP(
                        etPersonName.getText().toString(),
                        etPersonAge.getText().toString(),
                        etPersonGender.getText().toString()
                );
//                Send person to second activity
                Intent intent = new Intent(getApplicationContext(),
                        SecondActivity.class);
                intent.putExtra(Constants.KEY.PERSON, person);
                intent.putExtra(Constants.KEY.PERSON_P, personP);
                startActivity(intent);

                break;
            case R.id.btnChangeTextView:
                tvMain.setText(etMain.getText().toString());
                break;
        }

    }
}
