package com.example.user.savingdata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class PersonListActivity extends AppCompatActivity {


    private ListView lvPersonList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_list);

        lvPersonList = (ListView) findViewById(R.id.lvPersons);


        String[] values = new String[]{
                "value1",
                "value2",
                "value3",
                "value4",

        };

        //setting the listview with dummy data initialized above
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, values);

        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        List<Person> personList = databaseHelper.getPersonList();


        //using custom list view adapter
        PersonListAdapter personListAdapter =
                new PersonListAdapter(this, R.layout.custom_list_item, personList);

        lvPersonList.setAdapter(personListAdapter);


    }
}
