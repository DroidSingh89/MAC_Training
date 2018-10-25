package com.example.user.androidviewsandviewgroups;

import android.util.Log;
import android.view.View;

public class ButtonClickHandler implements View.OnClickListener{


    @Override
    public void onClick(View v) {

        Log.d("SomeTag", "onClick: " + v.getId());

    }
}
