package com.example.user.listlikeviews.view.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.user.listlikeviews.R;
import com.example.user.listlikeviews.model.PersonGenerator;

public class RecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        RecyclerView rvPersonList = findViewById(R.id.rvPerson);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(PersonGenerator.generate(20));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvPersonList.setAdapter(adapter);
        rvPersonList.setLayoutManager(layoutManager);



    }
}
