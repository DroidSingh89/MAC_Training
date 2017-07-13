package com.example.singh.mvp_dagger.view.activites.secondactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.singh.mvp_dagger.R;
import com.example.singh.mvp_dagger.model.Person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "SecondActivityTag";
    List<Person> personList  = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        personList = (List<Person>) getIntent().getSerializableExtra("personList");

        for (int i = 0; i < personList.size(); i++) {
            Log.d(TAG, "onCreate: " + personList.get(i).getFirstName());

        }

    }
}
