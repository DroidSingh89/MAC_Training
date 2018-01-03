package com.example.user.mvvm_databinding;

import android.util.Log;
import android.view.View;

import com.example.user.mvvm_databinding.model.Person;

/**
 * Created by singh on 1/3/18.
 */

public class MainViewModel {

    private static final String TAG = MainViewModel.class.getSimpleName();
    

    public void onClick(View view) {
        Log.d(TAG, "onClick: This was clicked");

    }

    public void onClickWithPerson(View view, Person person) {
        Log.d(TAG, "onClick: " + person.toString());

    }

    public void onClickObsPerson(View view, Person person) {
        Log.d(TAG, "onClickObsPerson: " + person.firstNameObs.get() +
                person.lastNameObs.get());
    }


}
