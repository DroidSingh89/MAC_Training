package com.example.singh.sharingdataviaintents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }

    public void sendPerson(View view) {


        SerializablePerson person = new SerializablePerson("John Doe", 30, "Male");

        Intent intent = new Intent(MainActivity.this, SerialiazablePersonActivity.class);
        intent.putExtra("serializablePerson", person);
        startActivity(intent);


    }
}
