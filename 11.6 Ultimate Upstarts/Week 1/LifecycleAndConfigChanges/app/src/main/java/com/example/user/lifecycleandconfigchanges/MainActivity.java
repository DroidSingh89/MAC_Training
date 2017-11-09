package com.example.user.lifecycleandconfigchanges;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.user.lifecycleandconfigchanges.utils.Constants;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTag";
    private TextView tvMain;
    private EditText etMain;
    private String updatedText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: ");

        etMain = findViewById(R.id.etMain);
        tvMain = findViewById(R.id.tvMain);

        updatedText = "Default value";

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
    protected void onSaveInstanceState(Bundle anyName) {
        super.onSaveInstanceState(anyName);
        Log.d(TAG, "onSaveInstanceState: ");
        anyName.putString("updatedText", etMain.getText().toString());
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "onRestoreInstanceState: ");
        tvMain.setText(savedInstanceState.getString("updatedText"));

    }

    public void goToSecondActivity(View view) {

        //create dataSerializable object
        DataSerializable dataSerializable
                = new DataSerializable(tvMain.getText().toString(), "Today", "Now");
        //start the second activity
        Intent intent
                = new Intent(this, Main2Activity.class);
        intent.putExtra(Constants.KEY.EXTRA_DATA_S, dataSerializable);
        intent.putExtra(Constants.KEY.EXTRA_DATA_P,
                new DataParcelable("Something"
        ,"Yesterday", "Then"));
        startActivity(intent);

    }

    public void updateTextView(View view) {

        updatedText = etMain.getText().toString();
        updateTheTextView();
        Log.d(TAG, "updateTextView: " + updatedText);
    }

    private void updateTheTextView() {
        tvMain.setText(updatedText);
    }


    //handling config changes yourself (not recommended by google)
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        Log.d(TAG, "onConfigurationChanged: ");

        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            Log.d(TAG, "onConfigurationChanged: landscape");
        }
        else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Log.d(TAG, "onConfigurationChanged: portrait");
        }


    }
}

