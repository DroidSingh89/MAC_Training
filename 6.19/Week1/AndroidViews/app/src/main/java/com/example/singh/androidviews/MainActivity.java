package com.example.singh.androidviews;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivityTAG";
    private TextView tvUpdatedName;
    //private Button btnUpdateName;
    private EditText etUpdateName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: ");
        tvUpdatedName = (TextView) findViewById(R.id.tvUpdatedName);
        //btnUpdateName = (Button) findViewById(R.id.btnUpdateName);
        etUpdateName = (EditText) findViewById(R.id.etName);


//        btnUpdateName.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//                String data = etUpdateName.getText().toString();
//                tvUpdatedName.setText(data);
//
//
//            }
//        });


    }

    public void doMagic(View view) {

        String data = etUpdateName.getText().toString();
        tvUpdatedName.setText(data);

        Log.d(TAG, "doMagic: " + data);

        Toast.makeText(this, "Calculated", Toast.LENGTH_SHORT).show();


    }

    public void goToSecond(View view) {

        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(intent);


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
}
