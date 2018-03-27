package com.example.user.activitylifecycleandintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.user.activitylifecycleandintent.model.PersonP;
import com.example.user.activitylifecycleandintent.model.PersonS;

public class MainActivity extends AppCompatActivity {


    private final String TAG = Tagger.get(this);
    private EditText etMain;
    private EditText etName;
    private EditText etAge;
    private EditText etGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: Instance is created");
        bindViews();


    }

    private void bindViews() {
        //bind the main one
        etMain = findViewById(R.id.etMain);

        //bind views for person
        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);
        etGender = findViewById(R.id.etGender);
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
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }


    public void onFinish(View view) {
        finish();
    }

    public void onHandlingClicks(View view) {

        switch (view.getId()) {
            case R.id.btnFinish:

                finish();
                break;

            case R.id.btnSecond:

                //init personS object
                String name = etName.getText().toString();
                String age = etAge.getText().toString();
                String gender = etGender.getText().toString();

                PersonS personS = new PersonS(name, age, gender);
                PersonP personP = new PersonP(name, age, gender);

                //go to second activity
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("data", etMain.getText().toString());
                //add personS to intent
                intent.putExtra("personS", personS);
                intent.putExtra("personP", personP);
                startActivity(intent);


                break;
        }
    }
}
