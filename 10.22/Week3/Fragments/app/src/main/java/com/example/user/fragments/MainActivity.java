package com.example.user.fragments;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.fragments.fragments.YellowFragment;

public class MainActivity extends AppCompatActivity implements YellowFragment.OnFragmentInteractionListener {

    private static final String TAG = MainActivity.class.getSimpleName() + "_TAG";
    private TextView tvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");

        tvMain = findViewById(R.id.tvMain);

    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    public void onAddingYellow(View view) {


//        YellowFragment yellowFragment = (YellowFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentHolder1);


        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentHolder1,
                        YellowFragment.newInstance("af", "ASdf")
                        , YellowFragment.TAG)
                .addToBackStack(YellowFragment.TAG)
                .commit();


    }

    @Override
    public void onFragmentInteraction(String data) {
        tvMain.setText(data);

    }

    @Override
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
