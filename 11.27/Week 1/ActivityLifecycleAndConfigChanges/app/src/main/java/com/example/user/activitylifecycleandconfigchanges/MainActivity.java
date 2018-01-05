package com.example.user.activitylifecycleandconfigchanges;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.user.activitylifecycleandconfigchanges.model.Person;
import com.example.user.activitylifecycleandconfigchanges.utils.Constants;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTag";
    private EditText etText;
    private TextView tvChangedText;
    private EditText etPersonName;
    private EditText etPersonAge;
    private EditText etPersonGender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");

//        bind the views
        etText = findViewById(R.id.etText);
        tvChangedText = findViewById(R.id.tvChangedText);

        etPersonName = findViewById(R.id.etPersonName);
        etPersonAge = findViewById(R.id.etPersonAge);
        etPersonGender = findViewById(R.id.etPersonGender);

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


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState: ");
        String retainableText = tvChangedText.getText().toString();
        outState.putString("data", retainableText);

    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "onRestoreInstanceState: ");
        String retrievedText = savedInstanceState.getString("data");
        tvChangedText.setText(retrievedText);


    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d(TAG, "onConfigurationChanged: ");
    }

    public void handleButtonClicks(View view) {

        switch (view.getId()) {
            case R.id.btnNextActivity:

                Intent intent = new Intent(this,SecondActivity.class);
                String data = etText.getText().toString();
                intent.putExtra(Constants.EXTRA.MAIN, data);
                startActivity(intent);


                break;
            case R.id.btnChangeText:

                String changedText = etText.getText().toString();
                tvChangedText.setText(changedText);

                break;
        }


    }

    public void sendPerson(View view) {


        Person person = new Person(
                etPersonName.getText().toString(),
                etPersonAge.getText().toString(),
                etPersonGender.getText().toString()
        );

        Intent intent = new Intent(this, PersonActivity.class);
        intent.putExtra("person", person);
        startActivity(intent);





    }
}
