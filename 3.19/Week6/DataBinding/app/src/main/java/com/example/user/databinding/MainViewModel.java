package com.example.user.databinding;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.example.user.databinding.model.Celebrity;

public class MainViewModel {

    Context context;

    public MainViewModel(Context context) {
        this.context = context;
    }

    public void onClick(View view, Celebrity celebrity) {

        Toast.makeText(context, celebrity.firstNameObs.get(), Toast.LENGTH_SHORT).show();
    }

}
