package com.example.user.databinding;

import android.view.View;

import com.example.user.databinding.model.Person;

/**
 * Created by singh on 12/5/17.
 */

public interface MainViewModel {

    void onClick(View view);
    void updatePerson(View view, Person person);
}
