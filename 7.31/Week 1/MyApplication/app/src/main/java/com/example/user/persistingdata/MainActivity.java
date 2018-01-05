package com.example.user.persistingdata;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private static final String MY_PREF_FILE = "mypref_file";
    private static final String TAG = "Lifecycle_Main";
    EditText editText1, editText2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText) findViewById(R.id.etVal1);
        editText2 = (EditText) findViewById(R.id.etVal2);

        Log.d(TAG, "onCreate: ");

    }

    public void saveData(View view) {

        SharedPreferences sharedPreferences = getSharedPreferences(MY_PREF_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("value1", editText1.getText().toString());
        editor.putString("value2", editText2.getText().toString());
        editor.commit();

        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);



    }

    public void getData(View view) {

        SharedPreferences sharedPreferencess = getSharedPreferences(MY_PREF_FILE, Context.MODE_PRIVATE);
        Log.d(TAG, "getData: " + sharedPreferencess.getString("value1", "default"));

    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        Log.d(TAG, "onConfigurationChanged: ");


        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE)
            Toast.makeText(this, "Landscape", Toast.LENGTH_SHORT).show();

        if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT)
            Toast.makeText(this, "Portrait", Toast.LENGTH_SHORT).show();

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



}
