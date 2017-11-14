package com.example.user.listandrecyclerviews;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lvMain;
    private List<Celebrity> celebrityList;
    private ListView lvCelebrity;
    private List<String> stringList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bindViews();
        initData();

        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1,
                        stringList);

        lvMain.setAdapter(arrayAdapter);

        CelebrityListAdapter celebrityListAdapter =
                new CelebrityListAdapter(this,
                        R.layout.celebrity_list_item,
                        celebrityList);


        lvCelebrity.setAdapter(celebrityListAdapter);
    }

    private void bindViews() {
        lvMain = findViewById(R.id.lvMain);
        lvCelebrity = findViewById(R.id.lvCelebrity);
    }

    private void initData() {
        stringList = new ArrayList<>();
        stringList.add("First");
        stringList.add("Second");
        stringList.add("Third");
        stringList.add("Fourth");

        celebrityList = new ArrayList<>();
        celebrityList.add(new Celebrity("Drake", 32, 200 ));
        celebrityList.add(new Celebrity("Jennifer aniston", 50, 130 ));
        celebrityList.add(new Celebrity("Tom Cruise", 54, 170 ));
    }

    public void goToRecycler(View view) {

        Intent intent = new Intent(this, RecyclerActivity.class);
        startActivity(intent);


    }
}
