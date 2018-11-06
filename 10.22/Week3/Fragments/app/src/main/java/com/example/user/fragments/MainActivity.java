package com.example.user.fragments;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.fragments.fragments.RedFragment;
import com.example.user.fragments.fragments.YellowFragment;

public class MainActivity extends AppCompatActivity implements YellowFragment.OnFragmentInteractionListener, RedFragment.OnFragmentInteractionListener {

    private static final String TAG = MainActivity.class.getSimpleName() + "_TAG";
    private TextView tvMain;
    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");

        tvMain = findViewById(R.id.tvMain);
        fm = getSupportFragmentManager();

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
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    public void onAddingYellow(View view) {
        fm.beginTransaction()
                .add(R.id.fragmentHolder1,
                        YellowFragment.newInstance("wer", "Wer"), YellowFragment.TAG)
                .addToBackStack(YellowFragment.TAG)
                .commit();
    }

    @Override
    public void onFragmentInteraction(String data) {
        tvMain.setText(data);

    }

    @Override
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void sendDataToRed(String textValue) {

        RedFragment redFragment = (RedFragment) fm.findFragmentById(R.id.fragmentHolder2);
        if (redFragment == null) addRedFragment(textValue);
        else redFragment.updateTextView(textValue);

    }

    public void onRemovingYellow(View view) {

        YellowFragment yellowFragment = (YellowFragment) getSupportFragmentManager().findFragmentByTag(YellowFragment.TAG);
        fm.beginTransaction()
                .remove(yellowFragment)
                .commit();

    }

    public void onRemovingRed(View view) {

        RedFragment redFragment = (RedFragment) fm.findFragmentById(R.id.fragmentHolder1);

        fm.beginTransaction()
                .remove(redFragment)
                .commit();
    }

    public void onAddingRed(View view) {

        addRedFragment("Default Text");
    }

    private void addRedFragment(String textValue) {
        fm.beginTransaction()
                .add(R.id.fragmentHolder2,
                        RedFragment.newInstance(textValue), RedFragment.TAG)
                .addToBackStack(RedFragment.TAG)
                .commit();
    }

    public void onRemovingFragment(View view) {


//        remove all fragments till the last yellow fragment, from the back stack as well
//        boolean result = fm.popBackStackImmediate(YellowFragment.TAG, FragmentManager.POP_BACK_STACK_INCLUSIVE);

//        remove all fragments till the last yellow fragment, from the back stack as well
//        does it inside the call, does not have a return type
//        fm.popBackStack(YellowFragment.TAG, FragmentManager.POP_BACK_STACK_INCLUSIVE);


//        removes the top fragment, async, does not return anything
//        fm.popBackStack();

//        remove the top fragment from back stack, inside the call and return boolean
//        fm.popBackStackImmediate();


    }

    @Override
    public void onFragmentInteraction(Uri uri) {


    }
}
