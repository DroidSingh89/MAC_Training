package com.example.user.databinding;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.example.user.databinding.model.Celebrity;

public class CelebrityViewModel {

    Context context;

    public CelebrityViewModel(Context context) {
        this.context = context;
    }

    public void onCelebrityReceived(View view, Celebrity celebrity) {

        Toast.makeText(context, celebrity.getName(), Toast.LENGTH_SHORT).show();

    }
}
