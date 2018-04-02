package com.example.user.listlikeviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.user.listlikeviews.adapter.RecyclerListAdapter;
import com.example.user.listlikeviews.data.AnimalFactory;
import com.example.user.listlikeviews.model.Animal;

import java.util.List;

public class RecyclerActivity extends AppCompatActivity {

    private RecyclerView rvMain;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerListAdapter adapter;
    List<Animal> animalList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        bindRecyclerView();

    }

    private void bindRecyclerView() {
        rvMain = findViewById(R.id.rvMain);
        layoutManager = new LinearLayoutManager(this);
        animalList = AnimalFactory.createAnimals();
        adapter = new RecyclerListAdapter(animalList);
        rvMain.setAdapter(adapter);
        rvMain.setLayoutManager(layoutManager);
    }

    public void onAddAnimals(View view) {
        animalList.addAll(AnimalFactory.getMoreAnimals());
        adapter.notifyDataSetChanged();

    }
}
