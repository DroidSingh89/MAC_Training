package com.example.user.databinding;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.user.databinding.model.Person;

/**
 * Created by singh on 9/28/17.
 */

public class ViewModel {

    Context context;

    public ViewModel(Context context) {
        this.context = context;
    }

    private static final String TAG = "ViewModelTag";

    public void onClick(View view){

        Log.d(TAG, "onClick: ");
        Toast.makeText(context, "onClick", Toast.LENGTH_SHORT).show();

    }


    public void onClickPerson(View view, Person person){
        Toast.makeText(context, person.getNameObs().get(), Toast.LENGTH_SHORT).show();

    }
}
