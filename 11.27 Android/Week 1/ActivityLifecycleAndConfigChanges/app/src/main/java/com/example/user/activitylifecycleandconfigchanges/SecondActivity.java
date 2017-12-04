package com.example.user.activitylifecycleandconfigchanges;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.user.activitylifecycleandconfigchanges.utils.Constants;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "SecondActivityTag";
    private TextView tvRetrievedData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seccond);
        Log.d(TAG, "onCreate: ");

        //bind the view
        tvRetrievedData = findViewById(R.id.tvPassedData);

        //retrieve the text
        String data = getIntent().getStringExtra(Constants.EXTRA.MAIN);
        tvRetrievedData.setText(data);

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
