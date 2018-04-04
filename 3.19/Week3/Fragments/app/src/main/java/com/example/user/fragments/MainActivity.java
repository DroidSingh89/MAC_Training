package com.example.user.fragments;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.user.fragments.fragments.BlueFragment;
import com.example.user.fragments.fragments.RedFragment;

public class MainActivity extends AppCompatActivity {

    private static final String BLUE_FRAG_TAG = "bluefragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onAddingFragments(View view) {

        switch (view.getId()) {

            case R.id.btnAddBlue:

                BlueFragment blueFragment = new BlueFragment();
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.flHolder1, blueFragment, BLUE_FRAG_TAG)
                        .addToBackStack(null)
                        .commit();

                break;

            case R.id.btnAddRed:

                RedFragment redFragment =
                        RedFragment.newInstance("FirstName", "LastName");

                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.flHolder2, redFragment, "REDTAG")
                        .addToBackStack("REDTAG")
                        .commit();

                break;

        }

    }
}
