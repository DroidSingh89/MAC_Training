package com.example.user.databinding;

import android.util.Log;
import android.view.View;

/**
 * Created by singh on 10/24/17.
 */

public class ViewModel {


    private static final String TAG = "ViewModelTag";

    public void printPerson(View view, Person person) {
        Log.d(TAG, "printPerson: " + person.toString());

    }

    public void printPersonObs(View view, Person person) {
        Log.d(TAG, "printPersonObs: "
                + person.getFirstNameObs().get()
                + " "
                + person.getLastNameObs().get());
    }
}
