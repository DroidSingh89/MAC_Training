package com.example.singh.sharedprefsqlite;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.ContactsContract;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.singh.sharedprefsqlite.Utils.Constants;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private static final String MY_PREF_FILE = "com.example.singh.sharedprefsqlite.preffile";
    private static final String KEY_NAME = "name";
    private static final String TAG = "MainActivityTag";

    private EditText editText;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editText = (EditText) findViewById(R.id.edittext);
        textView = (TextView) findViewById(R.id.textview);


    }

    public void savePref(View view) {

        SharedPreferences sharedPreferences = getSharedPreferences(MY_PREF_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(getString(R.string.KEY_NAME), editText.getText().toString());
        editor.commit();
        Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();


    }

    public void viewPref(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences(MY_PREF_FILE, Context.MODE_PRIVATE);
        textView.setText(sharedPreferences.getString(getString(R.string.KEY_NAME), "manroop"));

    }

    public void saveContact(View view) {

        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        databaseHelper.saveNewContact("manroop", "90347629342");

    }


    public void getContact(View view) {

        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        databaseHelper.getContact();

    }


    public void saveToFile() throws FileNotFoundException {

        String fileData = "HelloWorld";

        File file = new File(getFilesDir(), "filename");
        FileOutputStream outputStream;


        try {
            outputStream = openFileOutput("filename", Context.MODE_PRIVATE);
            outputStream.write(fileData.getBytes());
            outputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
