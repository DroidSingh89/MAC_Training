package com.example.singh.listreccardview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private ListView lvContacts;

    private RecyclerView rvContacts;
    private RecyclerView.LayoutManager layoutManager;
    private DefaultItemAnimator defaultItemAnimator;
    private List<Contact> contactList = new ArrayList<>();
    private ContactListAdapter contactListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Populating the listview
        lvContacts = (ListView) findViewById(R.id.lvContacts);
        String[] values = new String[]{"Richard", "Will", "Raul", "Ace", "Michael"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, android.R.id.text1, values);
        lvContacts.setAdapter(adapter);

//        LvContactListAdapter contactListAdapter = new LvContactListAdapter();
//        lvContacts.setAdapter(contactListAdapter);


        //Populating the recycler view
        contactList.add(new Contact("Richard", "23424234234"));
        contactList.add(new Contact("Raul", "5452345345"));
        contactList.add(new Contact("Ace", "9992349234"));
        contactList.add(new Contact("Michael", "989834234"));
        contactList.add(new Contact("William", "6662723892"));


        rvContacts = (RecyclerView) findViewById(R.id.rvContacts);
        layoutManager = new LinearLayoutManager(this);
        defaultItemAnimator = new DefaultItemAnimator();
        contactListAdapter = new ContactListAdapter(contactList, this);
        rvContacts.setLayoutManager(layoutManager);
        rvContacts.setItemAnimator(defaultItemAnimator);
        rvContacts.setAdapter(contactListAdapter);


    }

    public void addNewContact(View view) {
        Contact contact = new Contact("Manny", "234234234");
        contactList.add(contact);
        contactListAdapter.notifyDataSetChanged();

        Intent intent = new Intent(this, DropDownActivity.class);
        startActivity(intent);

    }


}
