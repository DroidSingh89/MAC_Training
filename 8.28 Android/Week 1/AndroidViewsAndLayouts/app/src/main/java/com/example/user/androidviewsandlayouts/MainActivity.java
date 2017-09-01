package com.example.user.androidviewsandlayouts;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivityTag";
    EditText etInputValue;
    Button btnUpdateTextView;
    TextView tvDisplayValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Log.d(TAG, "onCreate: ");
        //bind all the views
        etInputValue = (EditText) findViewById(R.id.etInputValue);
        btnUpdateTextView = (Button) findViewById(R.id.btnUpdateTextView);
        tvDisplayValue = (TextView) findViewById(R.id.tvDisplayValue);


        btnUpdateTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                updateText();

            }
        });


    }


    //callback for the activity


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


    public void updateTextView(View view) {

        switch (view.getId()) {
            case R.id.btnUpdateTextView:

                updateText();
                break;

            case R.id.btnUpdateTextViewAdd:
                updateTextAdd();


                break;
        }

    }

    private void updateText() {
        String inputValue = etInputValue.getText().toString();
        tvDisplayValue.setText(inputValue);
    }


    private void updateTextAdd() {
        String inputValue = etInputValue.getText().toString();
        tvDisplayValue.setText(inputValue + "some");
    }


}
