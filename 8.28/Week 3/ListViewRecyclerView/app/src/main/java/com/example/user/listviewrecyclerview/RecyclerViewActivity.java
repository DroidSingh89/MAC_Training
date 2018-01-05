package com.example.user.listviewrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    RecyclerView rvPersonList;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.ItemAnimator itemAnimator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        //create a list of person objects
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Bill Clinton", 65, "Male", 167));
        personList.add(new Person("Tom Cruise", 56, "Male", 142));
        personList.add(new Person("Jennifer Aniston", 50, "Female", 150));


        rvPersonList = findViewById(R.id.rvPersonList);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter( personList);
        rvPersonList.setAdapter(adapter);
        layoutManager = new LinearLayoutManager(this);
        itemAnimator = new DefaultItemAnimator();
        rvPersonList.setLayoutManager(layoutManager);
        rvPersonList.setItemAnimator(itemAnimator);



    }
}
