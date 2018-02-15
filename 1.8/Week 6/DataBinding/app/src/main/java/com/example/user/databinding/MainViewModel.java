package com.example.user.databinding;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.example.user.databinding.model.Celebrity;

/**
 * Created by singh on 2/14/18.
 */

public class MainViewModel {

    Context context;

    public MainViewModel(Context context) {
        this.context = context;
    }

    public void onCelebReceived(View view, Celebrity celebrity) {

        Toast.makeText(context, celebrity.toString(), Toast.LENGTH_SHORT).show();

    }

}
