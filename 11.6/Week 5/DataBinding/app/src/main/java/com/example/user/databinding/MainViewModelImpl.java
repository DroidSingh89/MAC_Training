package com.example.user.databinding;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.example.user.databinding.model.Person;

/**
 * Created by singh on 12/5/17.
 */

public class MainViewModelImpl implements MainViewModel {


    Context context;

    public MainViewModelImpl(Context context) {
        this.context = context;
    }

    @Override
    public void onClick(View view) {

        Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void updatePerson(View view, Person person) {

        Toast.makeText(context, person.getNameObs().get(), Toast.LENGTH_SHORT).show();

    }


}
