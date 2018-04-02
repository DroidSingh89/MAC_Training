package com.example.user.listlikeviews;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.user.listlikeviews.adapter.CustomListAdapter;
import com.example.user.listlikeviews.data.AnimalFactory;
import com.example.user.listlikeviews.listeners.SimpleListListener;
import com.example.user.listlikeviews.model.Animal;

public class MainActivity extends AppCompatActivity implements CustomListAdapter.OnClickInteraction {

    private ListView lvSimple;
    private ListView lvCustom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
        bindSimpleList();
        bindCustomListView();

    }

    private void bindCustomListView() {
        CustomListAdapter customListAdapter =
                new CustomListAdapter(this,
                        R.layout.simple_list_item,
                        AnimalFactory.createAnimals());
        lvCustom.setAdapter(customListAdapter);
    }

    private void bindSimpleList() {
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_list_item_1,
                        AnimalFactory.createSimpleAnimals());
        lvSimple.setAdapter(arrayAdapter);
        lvSimple.setOnItemClickListener(new SimpleListListener());
    }

    private void bindViews() {
        lvSimple = findViewById(R.id.lvSimple);
        lvCustom = findViewById(R.id.lvCustom);
    }


    @Override
    public void onItemClick(Animal animal) {

        Toast.makeText(this, animal.toString(), Toast.LENGTH_SHORT).show();
    }

    public void goToRecyclerActivity(View view) {
        Intent intent
                = new Intent(
                getApplicationContext(),
                RecyclerActivity.class);
        startActivity(intent);

    }
}
