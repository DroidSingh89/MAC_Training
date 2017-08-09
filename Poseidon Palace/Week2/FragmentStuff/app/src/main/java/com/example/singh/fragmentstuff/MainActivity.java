package com.example.singh.fragmentstuff;

import android.app.Fragment;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements RedFragment.OnFragmentInteractionListener, BlueFragment.OnFragmentInteractionListener, YellowFragment.OnYellowFragmentInteractionListener {

    private static final String RED_FRAGMENT_TAG = "RedFragmentTag";
    private static final String BLUE_FRAGMENT_TAG = "BlueFragmentTag";
    private static final String YELLOW_FRAGMENT_TAG = "YellowFragmentTag";

    TextView tvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvMain = (TextView) findViewById(R.id.tvMain);
    }

    public void addRedFrag(View view) {

        RedFragment redFragment = new RedFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.flFirstFrag, redFragment, RED_FRAGMENT_TAG)
                .addToBackStack(RED_FRAGMENT_TAG)
                .commit();

    }


    @Override
    public void onFragmentInteraction(String str) {

        tvMain.setText(str);


    }

    public void addBlueFrag(View view) {

        BlueFragment blueFragment = new BlueFragment();
        Bundle bundle = new Bundle();
        bundle.putString("key", "This is the new value");
        blueFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.flSecondFrag, blueFragment, BLUE_FRAGMENT_TAG)
                .addToBackStack(BLUE_FRAGMENT_TAG)
                .commit();

    }

    @Override
    public void onBlueFragmentInteraction(String str) {

    }

    public void addYellowFrag(View view) {

        YellowFragment yellowFragment = YellowFragment.newInstance("Manroop", "Singh");
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.flFirstFrag, yellowFragment, YELLOW_FRAGMENT_TAG)
                .addToBackStack(YELLOW_FRAGMENT_TAG)
                .commit();


    }

    @Override
    public void onYellowFragmentInteraction(String str) {

    }

    public void removeRed(View view) {

        android.support.v4.app.Fragment fragment = getSupportFragmentManager().findFragmentByTag(RED_FRAGMENT_TAG);
        getSupportFragmentManager().beginTransaction().remove(fragment).commit();


    }
}
