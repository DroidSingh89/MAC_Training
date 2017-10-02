package com.example.user.savingdata;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivityTag";
    private EditText etSaveDataToSharedPref;
    private TextView tvGetDataFromSharedPref;
    private EditText etPersonName;
    private EditText etPersonGender;
    private EditText etPersonAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //bind views for SHared pref
        etSaveDataToSharedPref = (EditText) findViewById(R.id.etSaveDataToSharedPref);
        tvGetDataFromSharedPref = (TextView) findViewById(R.id.tvDataFromSharedPref);

        //bind views for SQL database
        etPersonName = (EditText) findViewById(R.id.etPersonName);
        etPersonGender = (EditText) findViewById(R.id.etPersonGender);
        etPersonAge = (EditText) findViewById(R.id.etPersonAge);


    }

    public void usingSharedPref(View view) {

        //Initialize the shared prep instance to save and retrieve data
        SharedPreferences sharedPreferences = getSharedPreferences("mySharedPref", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        switch (view.getId()) {


            case R.id.btnSaveDataToSharedPref:
                //using the editor to save the value in the shared pref xml file

                editor.putString("data", etSaveDataToSharedPref.getText().toString());
                boolean isSaved = editor.commit();

                //toast if saved or not
                if (isSaved)
                    Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(this, "Not Saved", Toast.LENGTH_SHORT).show();


                break;
            case R.id.btnGetDataFromSharedPref:

                String data = sharedPreferences.getString("data", "defaultValue");
                tvGetDataFromSharedPref.setText(data);


                break;

            case R.id.btnClearAllSharedPref:

                boolean isCleared = editor.clear().commit();
                if (isCleared)
                    Toast.makeText(this, "Cleared", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(this, "Not Cleared", Toast.LENGTH_SHORT).show();

                break;

        }

    }

    public void usingSQLite(View view) {

        DatabaseHelper databaseHelper = new DatabaseHelper(this);

        switch (view.getId()){

            case R.id.btnSavePersonToDB:

                String personName = etPersonName.getText().toString();
                String personGender = etPersonGender.getText().toString();
                String personAge = etPersonAge.getText().toString();

                Person person= new Person(personName, personAge, personGender);

                long rowId = databaseHelper.savePerson(person);

                Toast.makeText(this, "Row id: " + rowId, Toast.LENGTH_SHORT).show();


                break;

            case R.id.btnGetPersonsFromDB:

                List<Person> personList = databaseHelper.getPersonList();
                for (int i = 0; i < personList.size(); i++) {
                    Log.d(TAG, "usingSQLite: " + personList.get(i).toString());
                }

                Intent intent = new Intent(this, PersonListActivity.class);
                startActivity(intent);

                break;
        }



    }
}
