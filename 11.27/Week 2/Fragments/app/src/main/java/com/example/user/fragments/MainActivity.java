package com.example.user.fragments;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.user.fragments.fragments.BlueFragment;
import com.example.user.fragments.fragments.YellowFragment;

public class MainActivity extends AppCompatActivity implements
        BlueFragment.OnFragmentInteractionListener {

    private static final String TAG = "MainActivityTag";
    private static final String BLUE_FRAG_TAG = "BlueFragmentTag";
    private static final String YELLOW_FRAG_TAG = "YellowFragmentTag";
    private TextView textView;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");
        textView = findViewById(R.id.tvDisplay);
        editText = findViewById(R.id.etMain);
    }

    //    Lifecycle methods
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

    public void addingFragments(View view) {

        switch (view.getId()) {


            case R.id.btnAddBlue:
                addBlueFragment("Data1", "Data2");
                break;

            case R.id.btnAddYellow:

                YellowFragment yellowFragment = new YellowFragment();

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flYellow,yellowFragment, YELLOW_FRAG_TAG)
                        .addToBackStack(YELLOW_FRAG_TAG)
                        .commit();

                break;

        }

    }

    public void sendDataToBlue(View view) {

        String data = editText.getText().toString();

//        get the instance of the fragment from the activity
        BlueFragment blueFragment = (BlueFragment) getSupportFragmentManager()
                .findFragmentById(R.id.flBlue);

        if (blueFragment != null) {
//            use a method to pass data to the fragment
            blueFragment.updateView(data);

        } else {
//            add the fragment and pass the data through the bundle
            addBlueFragment("From activity: ", data);

        }


    }

    private void addBlueFragment(String s1, String s2) {

        //BlueFragment blueFragment = (BlueFragment) getSupportFragmentManager().findFragmentByTag(BLUE_FRAG_TAG);
        BlueFragment blueFragment =
                BlueFragment.newInstance(s1, s2);

        blueFragment.setRetainInstance(true);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.flBlue, blueFragment,BLUE_FRAG_TAG)
                //.addToBackStack(BLUE_FRAG_TAG)
                .commit();
    }

    @Override
    public void onFragmentInteraction(String s) {

        textView.setText(s);

    }

    public void removeBlueFrag(View view) {

        BlueFragment blueFragment = (BlueFragment) getSupportFragmentManager().findFragmentByTag(BLUE_FRAG_TAG);

        if(blueFragment!=null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .remove(blueFragment)
                    .commit();
        }

    }

    public void removeYellowFrag(View view) {
        YellowFragment yellowFragment = (YellowFragment) getSupportFragmentManager().findFragmentByTag(YELLOW_FRAG_TAG);

        if(yellowFragment!=null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .remove(yellowFragment)
                    .commit();
        }
    }

    public void removeAllFrags(View view) {

        while (getSupportFragmentManager().popBackStackImmediate()){}

    }

    public void removeImmediate(View view) {

        getSupportFragmentManager().popBackStackImmediate();
    }
}
