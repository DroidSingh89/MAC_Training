package com.example.user.activitylifecycleandintent.view;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.user.activitylifecycleandintent.R;
import com.example.user.activitylifecycleandintent.model.Person;
import com.example.user.activitylifecycleandintent.model.PersonP;
import com.example.user.activitylifecycleandintent.utils.Constants;
import com.example.user.activitylifecycleandintent.utils.TagIt;

public class MainActivity extends AppCompatActivity {


    public static final String PERSON = "person";
    private EditText etMain;
    private TextView tvMain;
    private EditText etPersonName;
    private EditText etPersonAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TagIt.with(this), "onCreate: ");

        bindViews();
    }

    private void bindViews() {
        etMain = findViewById(R.id.etMain);
        tvMain = findViewById(R.id.tvMain);
        etPersonName = findViewById(R.id.etPersonName);
        etPersonAge = findViewById(R.id.etPersonAge);
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TagIt.with(this), "onStart: ");
    }

    @Override

    protected void onResume() {
        super.onResume();
        Log.d(TagIt.with(this), "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TagIt.with(this), "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TagIt.with(this), "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TagIt.with(this), "onDestroy: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TagIt.with(this), "onRestart: ");
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d(TagIt.with(this), "onConfigurationChanged: " + newConfig.orientation);

    }

    public void onChangeTextView(View view) {
        tvMain.setText(etMain.getText().toString());
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TagIt.with(this), "onSaveInstanceState: ");

        outState.putString(Constants.KEY.TV_MAIN, tvMain.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TagIt.with(this), "onRestoreInstanceState: ");

        String string = savedInstanceState.getString(Constants.KEY.TV_MAIN);
        tvMain.setText(string);
    }


    public void onSecondActivity(View view) {


        Intent intent = new Intent(getApplicationContext(),
                SecondActivity.class);


//put string extra
        intent.putExtra(Constants.KEY.TV_MAIN
                , etMain.getText().toString());

        switch (view.getId()) {
            case R.id.btnFirst:

                //create person object
                Person person = new Person(etPersonName.getText().toString(),
                        etPersonAge.getText().toString().trim());
                //put person as extra to intent
                intent.putExtra(PERSON, person);
                break;


            case R.id.btnSecond:
                //create person object
                PersonP personP = new PersonP(etPersonName.getText().toString(),
                        etPersonAge.getText().toString().trim());
                //put person as extra to intent
                intent.putExtra(PERSON, personP);

                break;
        }

        //start activity
        startActivity(intent);


    }
}

