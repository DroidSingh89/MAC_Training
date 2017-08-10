package com.example.user.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Food> foodList = new ArrayList<>();

    RecyclerView rvFoodList;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.ItemAnimator itemAnimator;
    FoodListAdapter foodListAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rvFoodList = (RecyclerView) findViewById(R.id.rvFoodList);
        layoutManager = new LinearLayoutManager(this);
        itemAnimator = new DefaultItemAnimator();
        rvFoodList.setLayoutManager(layoutManager);
        rvFoodList.setItemAnimator(itemAnimator);
        //initialize the adapter
        foodListAdapter =  new FoodListAdapter(foodList);
        rvFoodList.setAdapter(foodListAdapter);

        initFoodList();
        foodListAdapter.notifyDataSetChanged();

    }

    private void initFoodList() {

        foodList.add(new Food("Burger", 12, 300, 4.5));
        foodList.add(new Food("Pizza", 34, 340, 4.9));
        foodList.add(new Food("Soup", 14, 500, 4.1));
        foodList.add(new Food("Fried rice", 15, 600, 2.5));
    }
}
