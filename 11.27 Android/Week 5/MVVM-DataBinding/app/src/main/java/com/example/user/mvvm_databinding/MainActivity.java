package com.example.user.mvvm_databinding;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.user.mvvm_databinding.databinding.ActivityMainBinding;
import com.example.user.mvvm_databinding.model.Person;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        ActivityMainBinding mainBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_main);


        mainBinding.setPerson(new Person("John", "Doe"));
        mainBinding.setViewmodel(new MainViewModel());

    }
}
