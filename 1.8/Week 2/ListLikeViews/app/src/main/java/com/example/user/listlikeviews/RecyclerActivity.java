package com.example.user.listlikeviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.user.listlikeviews.data.LocalDataSource;

public class RecyclerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);


        RecyclerView rvPersonList = findViewById(R.id.rvPersonList);
        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(this);
        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();

        CustomRecyclerAdapter customRecyclerAdapter
                = new CustomRecyclerAdapter(LocalDataSource.getPersonList());

        rvPersonList.setAdapter(customRecyclerAdapter);
        rvPersonList.setLayoutManager(layoutManager);
        rvPersonList.setItemAnimator(itemAnimator);


    }
}
