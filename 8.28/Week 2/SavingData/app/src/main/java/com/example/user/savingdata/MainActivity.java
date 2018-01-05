package com.example.user.savingdata;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {


    private static final String MY_PREF_FILE = "com.example.user.savingdata.mypreffile";
    EditText etSaveData;
    EditText etName;
    EditText etPhone;
    TextView tvRetrievedData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etSaveData = (EditText) findViewById(R.id.etSaveData);
        etName = (EditText) findViewById(R.id.etName);
        etPhone = (EditText) findViewById(R.id.etPhone);

        tvRetrievedData = (TextView) findViewById(R.id.tvRetrievedData);


    }


    public void usingSharedPref(View view) {

        SharedPreferences sharedPreferences = getSharedPreferences(MY_PREF_FILE, Context.MODE_PRIVATE);


        switch (view.getId()) {

            case R.id.btnSaveData:

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("keyData", etSaveData.getText().toString());

                boolean isSaved = editor.commit();


                if (isSaved)
                    Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(this, "Not Saved", Toast.LENGTH_SHORT).show();

                break;

            case R.id.btnRetrieveData:

                String retrievedData = sharedPreferences.getString("keyData", "default");
                tvRetrievedData.setText(retrievedData);
                break;

        }

    }

    public void usingSQLite(View view) throws IOException {

        DatabaseHelper databaseHelper = new DatabaseHelper(this);

        switch (view.getId()) {

            case R.id.btnSaveDataSQL:

                String name = etName.getText().toString();
                String phone = etPhone.getText().toString();
                long rowNumber = databaseHelper.saveNewContact(name, phone);
                Toast.makeText(this, "Data saved at row" + rowNumber, Toast.LENGTH_SHORT).show();

                break;

            case R.id.btnGetDataSQL:

                databaseHelper.getContacts();
                break;
        }
        
    }

}
