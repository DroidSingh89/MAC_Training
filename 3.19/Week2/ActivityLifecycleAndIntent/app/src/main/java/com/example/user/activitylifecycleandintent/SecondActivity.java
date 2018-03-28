package com.example.user.activitylifecycleandintent;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.activitylifecycleandintent.model.PersonP;
import com.example.user.activitylifecycleandintent.model.PersonS;

public class SecondActivity extends AppCompatActivity {

    private final String TAG = Tagger.get(this);
    private TextView tvSecond;
    private EditText etConfig;
    private TextView tvConfig;
    private EditText etShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d(TAG, "onCreate: ");


        //bind view
        tvSecond = findViewById(R.id.tvSecond);
        etConfig = findViewById(R.id.etConfig);
        tvConfig = findViewById(R.id.tvConfig);
        etShare = findViewById(R.id.etShare);


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

    public void onUpdateTextview(View view) {

        tvConfig.setText(etConfig.getText().toString());

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState: ");
        //save data to the bundle
        String tvValue = tvConfig.getText().toString();
        outState.putString("data", tvValue);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "onRestoreInstanceState: ");
        //restore the values from the bundle
        String tvValue = savedInstanceState.getString("data");
        tvConfig.setText(tvValue);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        Log.d(TAG, "onConfigurationChanged: ");
    }

    public void onShareData(View view) {

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, etShare.getText().toString());
        intent.setType("text/plain");
        startActivity(intent);

    }
}
