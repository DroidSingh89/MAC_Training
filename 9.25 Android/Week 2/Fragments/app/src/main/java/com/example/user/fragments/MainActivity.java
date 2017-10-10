package com.example.user.fragments;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
implements YellowFragment.OnFragmentInteractionListener{

    private static final String BLUE_FRAG_TAG = "BlueFragmentTag";
    private static final String GREEN_FRAG_TAG = "GreenFragmentTag";
    private static final String YELLOW_FRAG_TAG = "YellowFragmentTag";
    private static final String TAG = "MainActivityTag";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }



    public void addingFragments(View view) {




        switch (view.getId()){


            case R.id.btnAddBlueFrag:

                addBlue();

                break;

            case R.id.btnAddGreenFrag:

                GreenFragment greenFragment = GreenFragment.newInstance("first", "second");

                getSupportFragmentManager().beginTransaction()
                        .add(R.id.frameGreen, greenFragment, GREEN_FRAG_TAG)
                        .addToBackStack(GREEN_FRAG_TAG)
                        .commit();


                break;


            case R.id.btnAddYellowFrag:
                YellowFragment yellowFragment = YellowFragment.newInstance("Sdf","sdf");


                yellowFragment.setRetainInstance(true);

                getSupportFragmentManager().beginTransaction()
                        .add(R.id.frameYellow, yellowFragment, YELLOW_FRAG_TAG)
                        .commit();
                addBlue();


                break;
            case R.id.btnAddTextToYellowFrag:


                //updating the textview in yellow fragment
                YellowFragment fragment = (YellowFragment) getSupportFragmentManager()
                        .findFragmentByTag(YELLOW_FRAG_TAG);

                String data = "Hello from Main activity";
                fragment.setText(data);

                //update the textview in the red fragment
                RedFragment redFragment = (RedFragment) getSupportFragmentManager()
                        .findFragmentById(R.id.fragRed);

                redFragment.showToast(data);


                //remove blue
                BlueFragment blueFragment = (BlueFragment) getSupportFragmentManager().findFragmentByTag(BLUE_FRAG_TAG);

                getSupportFragmentManager().beginTransaction()
                        .remove(blueFragment)
                        .commit();

                break;


        }


    }

    private void addBlue() {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.frameBlue, new BlueFragment(), BLUE_FRAG_TAG)
                .addToBackStack(BLUE_FRAG_TAG)
                .commit();
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

    //default method added on fragment interaction interface
    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    //created another interface method to be called from the fragment to activity
    @Override
    public void setData(String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();

    }
}
