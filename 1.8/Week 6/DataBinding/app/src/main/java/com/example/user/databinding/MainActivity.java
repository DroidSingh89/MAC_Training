package com.example.user.databinding;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.user.databinding.databinding.ActivityMainBinding;
import com.example.user.databinding.model.Celebrity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        ActivityMainBinding activityMainBinding
                = DataBindingUtil.setContentView(this, R.layout.activity_main);

        activityMainBinding.setCeleb(new Celebrity("Black", "Panther", "Uni", "Marvel"));
        activityMainBinding.setViewModel(new MainViewModel(this));

    }
}
