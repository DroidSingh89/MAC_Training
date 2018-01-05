package com.example.user.listandrecyclerviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity {

    private List<Celebrity> celebrityList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);


        celebrityList = new ArrayList<>();
        celebrityList.add(new Celebrity("Drake", 32, 200 ));
        celebrityList.add(new Celebrity("Jennifer aniston", 50, 130 ));
        celebrityList.add(new Celebrity("Tom Cruise", 54, 170 ));


        RecyclerView recyclerView = findViewById(R.id.rvMain);
        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(this);
        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        CelebrityRecyclerAdapter celebrityRecyclerAdapter =
                new CelebrityRecyclerAdapter(celebrityList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(itemAnimator);
        recyclerView.setAdapter(celebrityRecyclerAdapter);



    }
}
