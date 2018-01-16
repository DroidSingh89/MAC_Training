package com.example.user.savingdata;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.savingdata.data.DatabaseHelper;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private EditText etSaveValue;
    private TextView tvDisplayValue;
    private EditText etPersonName;
    private EditText etPersonGender;
    private EditText etPersonAge;
    private ListView lvPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
    }

    private void bindViews() {
        etSaveValue = findViewById(R.id.etSaveValue);
        tvDisplayValue = findViewById(R.id.tvDisplayValue);

        etPersonName = findViewById(R.id.etPersonName);
        etPersonGender = findViewById(R.id.etPersonGender);
        etPersonAge = findViewById(R.id.etPersonAge);

        lvPerson = findViewById(R.id.lvPerson);
    }

    public void onSharedPref(View view) {

        //get the value from the edit text
        String data = etSaveValue.getText().toString();

//        create the shared pref object
        SharedPreferences sharedPreferences
                = getSharedPreferences("mySharedPref", Context.MODE_PRIVATE);

        switch (view.getId()) {
            case R.id.btnSaveValue:
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("edittext", data);
                boolean isSaved = editor.commit();
                if (isSaved) {
                    Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btnRetrieveValue:
//                added "default" to have some default value in case of returning string
//                to be null
                String dataRetrieved =
                        sharedPreferences.getString("edittext", "default");

                tvDisplayValue.setText(dataRetrieved);

                break;
        }
    }

    public void onHandlingDatabase(View view) {

//        Create the database object
        DatabaseHelper database = new DatabaseHelper(this);
        String personName, personAge, personGender;
        personName = etPersonName.getText().toString();
        personAge = etPersonAge.getText().toString();
        personGender = etPersonGender.getText().toString();
        Person person = new Person(personName, personAge, personGender);

        switch (view.getId()) {
            case R.id.btnSavePerson:
                long rowNumber = database.savePerson(person);
                if (rowNumber > 0)
                    Toast.makeText(this, "Person saved at " + rowNumber, Toast.LENGTH_SHORT).show();
                else Toast.makeText(this, "Person not saved", Toast.LENGTH_SHORT).show();

                break;

            case R.id.btnGetPersonList:
                final List<Person> personList = database.getPersonList();
                Log.d(TAG, "onHandlingDatabase: " + personList.toString());

                ArrayAdapter<Person> personArrayAdapter
                        = new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1, personList);
                lvPerson.setAdapter(personArrayAdapter);

                lvPerson.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String displayValue =
                                personList.get(position).getName() + " was clicked";
                        Toast.makeText(MainActivity.this, displayValue, Toast.LENGTH_SHORT).show();
                    }
                });


                break;
        }
    }
}
