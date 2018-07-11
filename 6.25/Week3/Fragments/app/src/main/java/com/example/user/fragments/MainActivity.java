package com.example.user.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.user.fragments.fragments.BlueFragment;
import com.example.user.fragments.fragments.RedFragment;

public class MainActivity extends AppCompatActivity
        implements
        BlueFragment.OnFragmentInteractionListener,
        RedFragment.onFragmentInteractor {


    private static final String TAG = MainActivity.class.getSimpleName() + "_TAG";
    private FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");
        fragmentManager = getSupportFragmentManager();
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
        Log.d(TAG, "onDestroy: ");
    }

    public void onAddingFragment(View view) {

        switch (view.getId()) {

            case R.id.btnAddRed:

                RedFragment redFragment = (RedFragment) fragmentManager.findFragmentById(R.id.fragHolder1);


                if (redFragment == null) {
                    Log.d(TAG, "onAddingFragment: ");
                    redFragment = new RedFragment();
                    fragmentManager.beginTransaction()
                            .add(R.id.fragHolder1, redFragment, RedFragment.STRING_TAG)
                            .addToBackStack(RedFragment.STRING_TAG)
                            .commit();
                }

                break;
            case R.id.btnAddBlue:

                BlueFragment blueFragment = (BlueFragment) fragmentManager.findFragmentById(R.id.fragHolder2);

                if (blueFragment == null) {
                    blueFragment = BlueFragment
                            .newInstance("data1", "data2");

                    fragmentManager.beginTransaction()
                            .add(R.id.fragHolder2, blueFragment, BlueFragment.STRING_TAG)
                            .addToBackStack(BlueFragment.STRING_TAG)
                            .commit();
                }

                break;
        }
    }

    @Override
    public void onFragmentInteraction(String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }

    public void onRemoveFragments(View view) {


//        get red fragment
        RedFragment redFragment = (RedFragment) fragmentManager
                .findFragmentByTag(RedFragment.STRING_TAG);

        BlueFragment blueFragment = (BlueFragment) fragmentManager
                .findFragmentById(R.id.fragHolder2);

        removeFragmentIfNotNull(redFragment);
        removeFragmentIfNotNull(blueFragment);

    }

    private void removeFragmentIfNotNull(Fragment fragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (fragment != null) {
            transaction.remove(fragment).commit();
            fragmentManager.popBackStackImmediate();
        }
    }

    @Override
    public void onDataFromRed(String data) {

        BlueFragment blueFragment = (BlueFragment) fragmentManager.findFragmentById(R.id.fragHolder2);

        if (blueFragment == null) {
            blueFragment = BlueFragment.newInstance("Data:", data);

            fragmentManager.beginTransaction()
                    .add(R.id.fragHolder2, blueFragment, BlueFragment.STRING_TAG)
                    .addToBackStack(null)
                    .commit();
        } else {
            blueFragment.updateData(data);
        }

    }
}
