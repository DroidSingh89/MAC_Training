package com.example.user.androidviewsandviewgroups;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG =
            MainActivity.class.getSimpleName() + "_TAG";

    TextView tvOne;
    Button btnChangeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        bind views
        tvOne = findViewById(R.id.tvOne);
        btnChangeView = findViewById(R.id.btnChangeView);

//
//        btnChangeView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                tvOne.setText(new Random().nextInt(100));
//
//            }
//        });

        btnChangeView.setOnClickListener(new ButtonClickHandler());


        Log.d(TAG, "onCreate:");
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
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
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

    public void updateTextViews(View view) {
        Toast.makeText(this, "Button clicked", Toast.LENGTH_SHORT).show();
    }
}
