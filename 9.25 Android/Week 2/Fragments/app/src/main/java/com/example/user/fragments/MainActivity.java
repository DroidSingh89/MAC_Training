package com.example.user.fragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String BLUE_FRAG_TAG = "BlueFragmentTag";
    private static final String GREEN_FRAG_TAG = "GreenFragmentTag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addingFragments(View view) {

        switch (view.getId()){


            case R.id.btnAddBlueFrag:

                getSupportFragmentManager().beginTransaction()
                        .add(R.id.frameBlue, new BlueFragment(), BLUE_FRAG_TAG)
                        .addToBackStack(BLUE_FRAG_TAG)
                        .commit();

                break;

            case R.id.btnAddGreenFrag:

                GreenFragment greenFragment = GreenFragment.newInstance("first", "second");

                getSupportFragmentManager().beginTransaction()
                        .add(R.id.frameGreen, greenFragment, GREEN_FRAG_TAG)
                        .addToBackStack(GREEN_FRAG_TAG)
                        .commit();
                break;




        }


    }
}
