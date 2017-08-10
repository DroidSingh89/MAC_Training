package com.example.user.handlingfragments;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements BlueFragment.OnFragmentInteractionListener {

    private static final String RED_FRAGMENT_TAG = "RedFragment";
    private static final String YELLOW_FRAGMENT_TAG = "YellowFragment";
    private static final String BLUE_FRAGMENT_TAG = "BlueFragment";
    TextView tvFromBlue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvFromBlue = (TextView) findViewById(R.id.tvFromBlue);

    }

    public void addFragments(View view) {

        switch (view.getId()) {

            case R.id.btnAddRed:

                RedFragment redFragment = new RedFragment();
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.flFrag1, redFragment, RED_FRAGMENT_TAG)
                        .addToBackStack(RED_FRAGMENT_TAG)
                        .commit();

                break;

            case R.id.btnAddYellow:
                YellowFragment yellowFragment = YellowFragment.newInstance("John", "Doe");
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.flFrag1, yellowFragment, YELLOW_FRAGMENT_TAG)
                        .addToBackStack(YELLOW_FRAGMENT_TAG)
                        .commit();
                break;

            case R.id.btnAddBlue:
                BlueFragment blueFragment = BlueFragment.newInstance("John", "Doe");
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.flFrag1, blueFragment, BLUE_FRAGMENT_TAG)
                        .addToBackStack(BLUE_FRAGMENT_TAG)
                        .commit();
                break;

        }

    }

    @Override
    public void onFragmentInteraction(String s) {

        tvFromBlue.setText(s);
        Toast.makeText(this, "Updated", Toast.LENGTH_SHORT).show();

    }

    public void removeFragments(View view) {

        switch (view.getId()) {

            case R.id.btnRemoveRed:

                Fragment fragmentRed = getSupportFragmentManager().findFragmentById(R.id.flFrag1);
                getSupportFragmentManager().beginTransaction()
                        .remove(fragmentRed)
                        .commit();

                break;

            case R.id.btnRemoveYellow:

                Fragment fragmentYellow = getSupportFragmentManager().findFragmentByTag(YELLOW_FRAGMENT_TAG);
                getSupportFragmentManager().beginTransaction()
                        .remove(fragmentYellow)
                        .commit();
                break;

            case R.id.btnRemoveBlue:

                Fragment fragmentBlue = getSupportFragmentManager().findFragmentByTag(BLUE_FRAGMENT_TAG);
                getSupportFragmentManager().beginTransaction()
                        .remove(fragmentBlue)
                        .commit();
                break;


            case R.id.btnRemoveAll:

                while (getSupportFragmentManager().getBackStackEntryCount() > 0) {
                    getSupportFragmentManager().popBackStackImmediate();
                }
        }


    }

}
