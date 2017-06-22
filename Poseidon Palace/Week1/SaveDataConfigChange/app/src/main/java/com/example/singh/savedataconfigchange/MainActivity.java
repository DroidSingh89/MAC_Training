package com.example.singh.savedataconfigchange;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private EditText editText;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView = (TextView) findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.editText);


    }

    public void changeText(View view) {


        String data = editText.getText().toString();
        textView.setText(data);

        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
        intent.putExtra("textview", data);
        startActivity(intent);



    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        String data = textView.getText().toString();
        outState.putString("textview", data);

    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);


        textView.setText(savedInstanceState.getString("textview"));
    }
}
