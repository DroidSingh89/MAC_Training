package com.example.user.databinding;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.user.databinding.databinding.ActivityMainBinding;

public class PersonActivity extends AppCompatActivity {

    private static final String TAG = PersonActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        setContentView(R.layout.activity_main);

        ActivityMainBinding mainBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_main);

        mainBinding.setPerson(new Person("John Doe", "Male", "45"));
        mainBinding.setPersonViewModel(new PersonViewModel());



    }
}
