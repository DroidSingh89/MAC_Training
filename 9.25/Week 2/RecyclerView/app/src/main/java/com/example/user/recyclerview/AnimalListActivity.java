package com.example.user.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class AnimalListActivity extends AppCompatActivity {


    List<Animal> animalList = new ArrayList<>();


    RecyclerView rvAnimalList;
    RecyclerView.LayoutManager layoutManagerLinear;
    RecyclerView.LayoutManager layoutManagerGrid;
    RecyclerView.ItemAnimator itemAnimator;
    AnimalListAdapter animalListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_list);

        String imageURL = "https://s3-us-west-1.amazonaws.com/powr/defaults/image-slider2.jpg";

        ImageView imageView = findViewById(R.id.ivTest);

        Glide.with(this).load(imageURL)
                .into(imageView);


        //Create animal data
        initAnimals(imageURL);

        //used for grid layouts
        layoutManagerGrid = new GridLayoutManager(this, 3);

        //used for linear layouts
        layoutManagerLinear = new LinearLayoutManager(this);
        itemAnimator = new DefaultItemAnimator();
        animalListAdapter = new AnimalListAdapter(this, animalList);

        rvAnimalList = findViewById(R.id.rvAnimalList);
        rvAnimalList.setLayoutManager(layoutManagerLinear);
        rvAnimalList.setItemAnimator(itemAnimator);
        rvAnimalList.setAdapter(animalListAdapter);

        

    }

    private void initAnimals(String imageURL) {
        animalList.add(new Animal("Cat", "Tiger", 400, imageURL));
        animalList.add(new Animal("Cat", "Lion", 450, imageURL));
        animalList.add(new Animal("Mammal", "Bear", 600, imageURL));
        animalList.add(new Animal("Fish", "Salmon", 20, imageURL));
    }
}
