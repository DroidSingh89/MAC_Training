package com.example.user.savingdata;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etDataSharedPref;
    private TextView tvDisplayDataSharedPref;
    private EditText etPersonName;
    private EditText etPersonGender;
    private TextView tvDisplayDataSQL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        bind views for shared pref
        etDataSharedPref = findViewById(R.id.etDataToBeSaved);
        tvDisplayDataSharedPref = findViewById(R.id.tvDisplayDataSharedPref);

//        bind views for sql
        etPersonName = findViewById(R.id.etPersonName);
        etPersonGender = findViewById(R.id.etPersonGender);
        tvDisplayDataSQL = findViewById(R.id.tvDisplayDataSQL);

    }

    public void handlingDataSharedPref(View view) {

        //create an instance of shared pref to save and retrieve data
        SharedPreferences sharedPreferences =
                getSharedPreferences("mySharedPref", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();


        //create a switch case for each button view
        switch (view.getId()) {

            case R.id.btnSaveDataSharedPref:

                editor.putString("key", etDataSharedPref.getText().toString());

                boolean isSaved = editor.commit();

                if (isSaved)
                    Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();

                break;

            case R.id.btnGetDataSharedPref:

                String data = sharedPreferences.getString("key", "default");
                tvDisplayDataSharedPref.setText(data);

                break;

            case R.id.btnClearDataSharedPref:
                editor.clear();
                editor.commit();

        }

    }

    public void handlingDataSQL(View view) {

        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        switch (view.getId()) {

            case R.id.btnSaveDataSQL:

                String name = etPersonName.getText().toString();
                String gender = etPersonGender.getText().toString();
                Person person = new Person(name, gender);

                long row = databaseHelper.savePerson(person);
                String toastString;
                if (row > 0)
                    toastString = "Saved at:" + row;
                else
                    toastString = "Not saved";

                Toast.makeText(this, toastString
                        , Toast.LENGTH_SHORT).show();

                break;


            case R.id.btnGetDataSQL:

                tvDisplayDataSQL.setText(databaseHelper.getPersons().toString());


                break;
        }

    }
}
