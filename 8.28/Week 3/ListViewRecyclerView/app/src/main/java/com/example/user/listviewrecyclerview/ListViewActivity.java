package com.example.user.listviewrecyclerview;

import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    ListView lvSimple;
    ListView lvCustom;
    ListView lvCustomVH;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        lvSimple = findViewById(R.id.lvSimple);
        lvCustom = findViewById(R.id.lvCustom);
        lvCustomVH = findViewById(R.id.lvCustomVH);

        List<String> personListSimple = new ArrayList<>();
        personListSimple.add("John Doe");
        personListSimple.add("John Doe1");
        personListSimple.add("John Doe2");
        personListSimple.add("John Doe3");


        //create an adapter for the simple list using the default layout
        ArrayAdapter<String> arrayAdapterSimple = new ArrayAdapter<>
                (this,android.R.layout.simple_list_item_1, personListSimple);
        //set the adapter to the simple list view
        lvSimple.setAdapter(arrayAdapterSimple);


        //create a list of person objects
        List<Person> personListCustom = new ArrayList<>();
        personListCustom.add(new Person("Bill Clinton", 65, "Male", 167));
        personListCustom.add(new Person("Tom Cruise", 56, "Male", 142));
        personListCustom.add(new Person("Jennifer Aniston", 50, "Female", 150));

        //create the custom adapter
        CustomListAdapter customListAdapter = new CustomListAdapter
                (this,R.layout.custom_list_item, personListCustom);
        lvCustom.setAdapter(customListAdapter);

        //create the custom adapter viewholder
        CustomVHListAdapter customVHListAdapter = new CustomVHListAdapter
                (this,R.layout.custom_list_item, personListCustom);
        lvCustomVH.setAdapter(customListAdapter);




    }
}
