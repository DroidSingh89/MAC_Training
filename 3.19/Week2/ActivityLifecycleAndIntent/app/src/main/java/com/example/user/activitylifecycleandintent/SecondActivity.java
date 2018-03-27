package com.example.user.activitylifecycleandintent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.activitylifecycleandintent.model.PersonP;
import com.example.user.activitylifecycleandintent.model.PersonS;

public class SecondActivity extends AppCompatActivity {

    private final String TAG = Tagger.get(this);
    private TextView tvSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d(TAG, "onCreate: ");


        //bind view
        tvSecond = findViewById(R.id.tvSecond);

        //get data from intent
        String data = getIntent().getStringExtra("data");
        PersonS personS = (PersonS) getIntent().getSerializableExtra("personS");
        tvSecond.setText(personS.toString());

        PersonP personP = getIntent().getParcelableExtra("personP");
        Toast.makeText(this, personP.toString(), Toast.LENGTH_SHORT).show();
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
}
