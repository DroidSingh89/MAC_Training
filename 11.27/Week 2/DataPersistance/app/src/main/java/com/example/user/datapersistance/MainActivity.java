package com.example.user.datapersistance;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTag";
    private EditText etPrefName;
    private TextView tvPrefName;
    private EditText etPersonName;
    private EditText etPersonAge;
    private EditText etPersonGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPrefName = findViewById(R.id.etPrefName);
        tvPrefName = findViewById(R.id.tvPrefName);

        etPersonName = findViewById(R.id.etPersonName);
        etPersonAge = findViewById(R.id.etPersonAge);
        etPersonGender = findViewById(R.id.etPersonGender);


    }

    public void handlePrefs(View view) {

        SharedPreferences sharedPreferences
                = getSharedPreferences("myPref", Context.MODE_PRIVATE);

        switch (view.getId()) {

            case R.id.btnSavePref:

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("name", etPrefName.getText().toString());
                boolean isSaved = editor.commit();

                if (isSaved)
                    Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();


                break;
            case R.id.btnGetPref:
                String prefName = sharedPreferences.getString("name", "default");
                tvPrefName.setText(prefName);


                break;
        }


    }

    public void usingSQLite(View view) {

        DatabaseHelper database = new DatabaseHelper(this);


        switch (view.getId()) {


            case R.id.btnSavePerson:
                Person person = new Person(
                        etPersonName.getText().toString()
                        , etPersonAge.getText().toString()
                        , etPersonGender.getText().toString());

                long rowId = database.savePerson(person);

                if (rowId > 0)
                    Toast.makeText(this, "Person saved at " + rowId, Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(this, "Person not saved", Toast.LENGTH_SHORT).show();

                break;

            case R.id.btnGetPersons:

                for (Person p : database.getPersons())
                    Log.d(TAG, "usingSQLite: " + p.toString());

                break;


        }

    }
}
