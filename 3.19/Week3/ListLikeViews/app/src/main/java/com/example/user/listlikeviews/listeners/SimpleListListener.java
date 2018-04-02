package com.example.user.listlikeviews.listeners;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

public class SimpleListListener implements AdapterView.OnItemClickListener{

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(view.getContext(), String.valueOf(i), Toast.LENGTH_SHORT).show();
    }


}
