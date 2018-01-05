package com.example.user.fragments;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements BlueFragment.OnFragmentInteractionListener {


    private static final String TAG = "MainActivityTag";
    private static final String RED_FRAGMENT_TAG = "RedFragment_Tag";
    private static final String BLUE_FRAGMENT_TAG = "BlueFragment_Tag";
    private TextView tvTextFromBlueFrag;
    private EditText etDataForRedFrag;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: ");

        tvTextFromBlueFrag = (TextView) findViewById(R.id.tvTextFromBlueFrag);
        etDataForRedFrag = (EditText) findViewById(R.id.etDataForRedFrag);


    }

    //callback to add the fragments
    public void addFragments(View view) {

        switch (view.getId()) {

            case R.id.btnAddRedFrag:

                addRedFragment("Initial data");
                break;

            case R.id.btnAddBlueFrag:
                String firstArg = "John";
                String secondArg = "Doe";

                addBlueFragment(firstArg, secondArg);


                break;
        }

    }

    private void addBlueFragment(String firstArg, String secondArg) {
        BlueFragment blueFragment = BlueFragment.newInstance(firstArg, secondArg);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.flFragHolderBlue, blueFragment, BLUE_FRAGMENT_TAG)
                .addToBackStack(BLUE_FRAGMENT_TAG)
                .commit();
    }

    //callback to remove the fragments
    public void removeFragments(View view) {

        switch (view.getId()) {

            case R.id.btnRemoveRedFrag:

                Fragment fragment = getSupportFragmentManager()
                        .findFragmentByTag(RED_FRAGMENT_TAG);

                if(fragment!=null){

                getSupportFragmentManager().beginTransaction()
                        .remove(fragment)
                        .commit();
                }
                else
                {
                    Toast.makeText(this, "There is no red frag", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btnRemoveBlueFrag:



                int totalFragments = getSupportFragmentManager().getBackStackEntryCount();
                Toast.makeText(this, String.valueOf(totalFragments), Toast.LENGTH_SHORT).show();

                break;
        }

    }

    private void addRedFragment(String dataFromActivity) {
        RedFragment redFragment = RedFragment.newInstance(dataFromActivity);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.flFragHolderRed, redFragment)
                .addToBackStack(RED_FRAGMENT_TAG)
                .commit();
    }

    //interface method for blue fragment
    @Override
    public void onFragmentInteraction(String data) {

    }

    //interface method for blue fragment
    @Override
    public void sendDataToActivity(String data) {
        tvTextFromBlueFrag.setText(data);

    }

    //button click for sending data to the red fragment
    public void sendDataToRedFrag(View view) {

        String dataForRedFrag = etDataForRedFrag.getText().toString();
        RedFragment redFragment = (RedFragment) getSupportFragmentManager()
                .findFragmentById(R.id.flFragHolderRed);


        if(redFragment !=null){

            redFragment.onDataReceived(dataForRedFrag);
        }
        else {

            addRedFragment(dataForRedFrag);
        }


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
