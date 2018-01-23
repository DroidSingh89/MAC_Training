package com.example.user.fragments;


import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.user.fragments.fragments.GreenFragment;
import com.example.user.fragments.fragments.RedFragment;

public class MainActivity extends AppCompatActivity
        implements GreenFragment.OnFragmentInteractionListener{

    public static final String TAG = MainActivity.class.getSimpleName();
    private static final String RED_FRAGMENT_TAG = RedFragment.class.getSimpleName();
    private static final String GREEN_FRAG_TAG = GreenFragment.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");

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
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroyView: ");
    }

    public void onHandlingRed(View view) {
//      create the fragment manager to do transactions
        FragmentManager fragmentManager = getSupportFragmentManager();

        switch (view.getId()) {

            case R.id.btnAddRed:

//                being transaction for adding the fragment
//                provide a tag for the red fragment when adding
                fragmentManager.beginTransaction()
                        .add(R.id.flRedFragment,new RedFragment(), RED_FRAGMENT_TAG)
                        .commit();
                break;

            case R.id.btnRemoveRed:
//                find the fragment that you want to remove by tag
                RedFragment redFragment
                        = (RedFragment) fragmentManager
                        .findFragmentByTag(RED_FRAGMENT_TAG);

//                being transaction to remove the fragment
                fragmentManager.beginTransaction()
                        .remove(redFragment)
                        .commit();

                break;

        }

    }

    public void onHandlingGreen(View view) {

        FragmentManager fragmentManager = getSupportFragmentManager();

        switch (view.getId()) {

            case R.id.btnAddGreen:

                GreenFragment greenFragment =
                        GreenFragment.newInstance("John" , "Doe");

                fragmentManager.beginTransaction()
                        .add(R.id.flGreenFragment, greenFragment, GREEN_FRAG_TAG)
                        .addToBackStack(GREEN_FRAG_TAG)
                        .commit();
                break;

            case R.id.btnRemoveGreen:

                break;
        }

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onButtonClick(String s) {

        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
