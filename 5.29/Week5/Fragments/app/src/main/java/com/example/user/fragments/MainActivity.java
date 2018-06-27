package com.example.user.fragments;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.user.fragments.fragments.BlueFragment;
import com.example.user.fragments.fragments.RedFragment;

public class MainActivity extends AppCompatActivity implements
RedFragment.OnFragmentInteractionListener, BlueFragment.OnFragmentInteractionListener{

    private TextView tvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
        addFragments();

    }

    private void bindViews() {
        tvMain = findViewById(R.id.tvMain);
    }

    private void addFragments() {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.flRedFrag, RedFragment.newInstance("", ""))
                .add(R.id.flBlueFrag, BlueFragment.newInstance("", ""))
                .commit();

    }


    @Override
    public void onFragmentInteraction(int intData) {

    }

//    data received from Red fragment
    @Override
    public void onFragmentInteraction(String string) {
        tvMain.setText(string);

//        update the textview in blue fragment
        BlueFragment blueFragment = (BlueFragment) getSupportFragmentManager()
                .findFragmentById(R.id.flBlueFrag);


        blueFragment.updateText(string);


    }
}
