package com.example.user.savingdataactivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    EditText editText;
    TextView textView;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.etname);
        textView = (TextView) findViewById(R.id.tvName);


    }

    public void changeText(View view) {

        String data = editText.getText().toString();
        textView.setText(data);


    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        String data = textView.getText().toString();
        outState.putString("data", data);

    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        textView.setText(savedInstanceState.getString("data"));


    }

    public void doSomething(View view) {


        switch (view.getId()) {

            case R.id.btnChangeText:
                break;

            case R.id.btnGoToSecond:


                List<Person> personList = new ArrayList<>();

                personList.add(new Person("sdf","sdf"));
                personList.add(new Person("sdfd","Sdf"));

                Intent intent = new Intent(this, SecondActivity.class);
                intent.putParcelableArrayListExtra("person", (ArrayList<? extends Parcelable>) personList);
                startActivity(intent);
                break;

            case R.id.btnShareData:

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,"This is a message");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);

        }


    }
}














