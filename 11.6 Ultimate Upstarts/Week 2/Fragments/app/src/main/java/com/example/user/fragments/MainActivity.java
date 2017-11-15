package com.example.user.fragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.user.fragments.fragments.BlueFragment;
import com.example.user.fragments.fragments.YellowFragment;

public class MainActivity extends AppCompatActivity implements YellowFragment.OnFragmentInteractionListener{

    private static final String BLUE_FRAGMENT_TAG = "BlueFragment";
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addingFragments(View view) {

        switch (view.getId()) {


            case R.id.btnAddBlue:

                String value1 = "value1";
                String value2 = "value2";

                addBlueFrag(value1, value2);

                break;

            case R.id.btnAddYellow:

                String val1 = "value1";
                String val2 = "value2";

                YellowFragment yellowFragment   = YellowFragment.newInstance(val1, val2);

                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fl_yellow, yellowFragment,"YellowFrag")
                        .commit();

                break;
        }

    }

    private void addBlueFrag(String value1, String value2) {
        BlueFragment blueFragment =
                BlueFragment.newInstance(value1, value2);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_blue, blueFragment,BLUE_FRAGMENT_TAG)
                .addToBackStack(BLUE_FRAGMENT_TAG)
                .commit();
    }

    public void removeFragments(View view) {

        switch (view.getId()){
            case R.id.btnRemoveBlue:

                BlueFragment blueFragment = (BlueFragment) getSupportFragmentManager()
                        .findFragmentByTag(BLUE_FRAGMENT_TAG);

                getSupportFragmentManager()
                        .beginTransaction()
                        .remove(blueFragment)
                        .commit();

        }
    }

    @Override
    public void onFragmentInteraction(String s) {
        //update the activity
        Log.d(TAG, "onFragmentInteraction: " + s);

        //let the activity update other fragments
        addBlueFrag("Data from Yellow: " , s);

    }
}
