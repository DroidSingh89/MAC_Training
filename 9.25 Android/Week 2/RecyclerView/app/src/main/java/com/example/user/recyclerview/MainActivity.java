package com.example.user.recyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private RecyclerView rvPersonList;

    RecyclerView.LayoutManager layoutManager;
    RecyclerView.ItemAnimator itemAnimator;
    private List<Person> personList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvPersonList = findViewById(R.id.rvPersonList);

        //Create person objects
        personList = new ArrayList<>();
        personList.add(new Person("John", "34"));
        personList.add(new Person("Mac", "22"));
        personList.add(new Person("Jason", "23"));
        personList.add(new Person("Joseph", "43"));
        personList.add(new Person("Jarett", "23"));
        personList.add(new Person("Ryen", "54"));

        layoutManager = new LinearLayoutManager(this);
        itemAnimator = new DefaultItemAnimator();
        PersonListAdapter personListAdapter = new PersonListAdapter(personList);

        rvPersonList.setLayoutManager(layoutManager);
        rvPersonList.setItemAnimator(itemAnimator);
        rvPersonList.setAdapter(personListAdapter);

    }

    public void goToAnimals(View view) {

        Intent intent = new Intent(this, AnimalListActivity.class);
        startActivity(intent);


    }
}
