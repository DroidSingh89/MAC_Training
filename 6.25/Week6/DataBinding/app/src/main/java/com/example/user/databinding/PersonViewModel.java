package com.example.user.databinding;

import android.util.Log;
import android.view.View;

import static android.content.ContentValues.TAG;

public class PersonViewModel{


    public void onPersonClicked(View view, Person person) {

        Log.d(TAG, "onPersonClicked: " + person.toString());

    }
}
