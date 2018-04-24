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

//        comment the method from the activity class
        //setContentView(R.layout.activity_main);

//        Call setContentView from the data binding library
        ActivityMainBinding mainBinding
                = DataBindingUtil.setContentView(
                this,
                R.layout.activity_main);

//        create a celebrity object
        Celebrity celebrity
                = new Celebrity(
                "Dwayne",
                "Johnson",
                "Hollywood");

//        set the celebrity object to binding object
        mainBinding.setCelebrity(celebrity);

        MainViewModel mainViewModel = new MainViewModel(this);
        mainBinding.setViewModel(mainViewModel);



    }
}
