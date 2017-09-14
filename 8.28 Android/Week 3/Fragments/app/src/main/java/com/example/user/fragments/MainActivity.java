package com.example.user.fragments;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements BlueFragment.OnFragmentInteractionListener {


    private static final String TAG = "MainActivityTag";
    private static final String RED_FRAGMENT_TAG = "RedFragment_Tag";
    private static final String BLUE_FRAGMENT_TAG = "BlueFragment_Tag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: ");


    }

    public void addFragments(View view) {

        switch (view.getId()) {

            case R.id.btnAddRedFrag:

                RedFragment redFragment = new RedFragment();
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.flFragHolderRed, redFragment, RED_FRAGMENT_TAG)
                        .commit();
                break;

            case R.id.btnAddBlueFrag:
                String firstArg = "John";
                String secondArg = "Doe";


                BlueFragment blueFragment = BlueFragment.newInstance(firstArg, secondArg);
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.flFragHolderBlue, blueFragment, BLUE_FRAGMENT_TAG)
                        .commit();


                break;
        }


    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onStart() {
        Log.d(TAG, "onStart: ");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.d(TAG, "onResume: ");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.d(TAG, "onPause: ");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.d(TAG, "onStop: ");
        super.onStop();
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy: ");
        super.onDestroy();
    }
}
