package com.example.user.databinding;

import android.util.Log;
import android.view.View;

/**
 * Created by singh on 8/30/17.
 */

public class ViewModel  {


    private static final String TAG = "ViewModelTag";

    public void onClick(View view) {

        Log.d(TAG, "onClick: ");

    }

    public void onClickPojo(View view, Person person) {

        Log.d(TAG, "onClick: " + person.getFirstName() + " " + person.getLastName());


    }



    public void onClickObs(View view, Person person) {

        Log.d(TAG, "onClick: " + person.getFirstNameObs().get() + " " + person.getLastNameObs().get());


    }

}