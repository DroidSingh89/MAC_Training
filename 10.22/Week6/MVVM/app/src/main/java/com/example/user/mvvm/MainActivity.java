package com.example.user.mvvm;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.user.mvvm.databinding.ActivityMainBinding;
import com.example.user.mvvm.model.Person;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = MainActivity.class.getSimpleName()+ "_TAG";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

//        generated binding class to set the content view
        ActivityMainBinding mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

//        init the view model with the reference to the lifecycle owner
        MainViewModel viewModel = ViewModelProviders.of(this).get(MainViewModel.class);

//        set variables used in the activity xml
        mainBinding.setPerson(new Person("John Doe", "35"));
        mainBinding.setViewmodel(viewModel);


//        observe live data objects
        viewModel.getPersonData().observe(this, new Observer<Person>() {
            @Override
            public void onChanged(@Nullable Person person) {
                Log.d(TAG, "onChanged: "+ person.toString());
            }
        });
    }
}
