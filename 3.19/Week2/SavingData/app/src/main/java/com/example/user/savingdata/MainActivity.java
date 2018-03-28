package com.example.user.savingdata;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.savingdata.data.LocalDataSource;
import com.example.user.savingdata.model.Person;

public class MainActivity extends AppCompatActivity {

    private EditText etSharedPref;
    private TextView tvSharedPref;
    private EditText etFirstName;
    private EditText etlastName;
    private EditText etgender;
    private TextView tvPersons;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
    }

    private void bindViews() {
        etSharedPref = findViewById(R.id.etSharedPref);
        tvSharedPref = findViewById(R.id.tvSharedPref);
        etFirstName = findViewById(R.id.etFirstName);
        etlastName = findViewById(R.id.etLastName);
        etgender = findViewById(R.id.etGender);
        tvPersons = findViewById(R.id.tvAllPersons);
    }

    public void handlingSharedPref(View view) {

        SharedPreferences sharedPreferences
                = getSharedPreferences("mySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        switch (view.getId()) {
            case R.id.btnSavePref:
                editor.putString("data", etSharedPref.getText().toString());

                boolean isSaved  = editor.commit();
                if (isSaved) {
                    Toast.makeText(this, "Date saved", Toast.LENGTH_SHORT).show();
                }else Toast.makeText(this, "Not saved", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btnRestorePref:

                tvSharedPref
                        .setText(sharedPreferences.getString("data", "defaultString"));

                break;
        }
    }

    public void handlingSQLite(View view) {

        LocalDataSource dataSource = new LocalDataSource(this);


        switch (view.getId()) {
            case R.id.btnSavePerson:
                Person person = new Person(
                        etFirstName.getText().toString(),
                        etlastName.getText().toString(),
                        etgender.getText().toString()
                );
                long rowNumber = dataSource.savePerson(person);

                Toast.makeText(this, String.valueOf(rowNumber), Toast.LENGTH_SHORT).show();


                break;

            case R.id.btnRetrievePersons:

                tvPersons.setText(dataSource.getAllPerson().toString());

                break;


        }


    }
}
