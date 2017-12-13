package com.example.user.listcontainers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.listcontainers.data.DataSource;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTag";
    private ListView lvSimple;
    private ListView lvAnimalList;
    private RecyclerView rvAnimalList;
    private RecyclerView.LayoutManager layoutManager;
    private AnimalRecyclerAdapter animalRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindViews();
        setupSimpleListView();
        setupCustomListView();


        TextView textView = new TextView(this);
        textView.setText("This is added dynamically");
        LinearLayout linearLayout = findViewById(R.id.linearLayout);
        linearLayout.addView(textView,1);


        //setup recycler view
        layoutManager = new GridLayoutManager(this, 2);
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this);
        animalRecyclerAdapter = new AnimalRecyclerAdapter(DataSource.getAnimalList(), this);
        rvAnimalList.setLayoutManager(linearLayoutManager);
        rvAnimalList.setAdapter(animalRecyclerAdapter);

        
    }

    private void bindViews() {
        lvSimple = findViewById(R.id.lvSimple);
        lvAnimalList = findViewById(R.id.lvAnimalList);
        rvAnimalList = findViewById(R.id.rvAnimalList);
    }

    private void setupCustomListView() {
        AnimalListAdapter animalListAdapter =
                new AnimalListAdapter(this,
                        R.layout.animal_list_item,
                        DataSource.getAnimalList());


        //lvAnimalList.setAdapter(animalListAdapter);
    }

    private void setupSimpleListView() {
        //create sample data for the listview
        List<String> stringList = DataSource.getSimpleData(5);

        //create the array adapter to populate the items
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                stringList);

        //set the adapter for the listview
        //lvSimple.setAdapter(arrayAdapter);

        //add a click listener to the list view
        lvSimple.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(MainActivity.this
                        , "Item position:" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
