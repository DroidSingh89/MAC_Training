package com.example.user.listlikeviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.user.listlikeviews.data.LocalDataSource;
import com.example.user.listlikeviews.model.Person;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lvSimple;
    private ListView lvCustom;
    private EditText etItems;
    private ArrayAdapter<String> arrayAdapterSimple;
    private List<String> defaultItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: 1/16/18 Create bind view method
        lvSimple = findViewById(R.id.lvSimple);
        lvCustom = findViewById(R.id.lvCustom);

        etItems = findViewById(R.id.etItems);

        //default items added to the list
        defaultItemList = LocalDataSource.getSimpleData(3);

        arrayAdapterSimple = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                defaultItemList);

        lvSimple.setAdapter(arrayAdapterSimple);


        //populate the custom list view with person list
        List<Person> personList = LocalDataSource.getPersonList();
        CustomListAdapter customListAdapter =
                new CustomListAdapter(this,
                        R.layout.custom_list_item,
                        personList);

        lvCustom.setAdapter(customListAdapter);

    }


    public void onItemCreate(View view) {

        int items = Integer.parseInt(etItems.getText().toString());

        defaultItemList.clear();
        defaultItemList.addAll(LocalDataSource.getSimpleData(items));
        arrayAdapterSimple.notifyDataSetChanged();
        Toast.makeText(this, "Items added", Toast.LENGTH_SHORT).show();


    }


}
