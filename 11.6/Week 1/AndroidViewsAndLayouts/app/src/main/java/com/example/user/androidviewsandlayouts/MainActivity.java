package com.example.user.androidviewsandlayouts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTag";
    private EditText etFirstName;
    private EditText etLastName;
    private TextView tvPersonName;
    private List<Person> personList = new ArrayList<>();
    private TextView tvNewFirstName;
    private TextView tvNewLastName;
    private TextView tvPersonFullName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();

    }

    private void bindViews() {
//        linear layout
        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        tvPersonName = findViewById(R.id.tvPersonName);

//        relative layout
        tvNewFirstName = findViewById(R.id.tvNewPersonFirstName);
        tvNewLastName = findViewById(R.id.tvNewPersonLastName);

//        frame layout
        tvPersonFullName = findViewById(R.id.tvPersonFullName);
    }


    public void goToSecondActivity(View view) {
        Log.d(TAG, "goToSecondActivity: ");

        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }

    public void savePersonName(View view) {

        String firstName = etFirstName.getText().toString();
        String lastName = etLastName.getText().toString();

        Person person = new Person(firstName, lastName);
        personList.add(person);

        Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();

    }

    public void displayPersons(View view) {

        tvPersonName.setText(personList.toString());
    }

    public void displayNewestPerson(View view) {

//        get the index of the last person and initialize the person object
        int index = personList.size() - 1;
        Person person = personList.get(index);

//        set the views as per the newest person object
//        relative layout
        tvNewFirstName.setText(person.getFirstName());
        tvNewLastName.setText(person.getLastName());

//        frame layout
        tvPersonFullName.setText(person.getFullName());
    }
}
