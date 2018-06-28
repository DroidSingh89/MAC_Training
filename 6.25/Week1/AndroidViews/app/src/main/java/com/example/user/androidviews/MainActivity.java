package com.example.user.androidviews;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tvFirst;
    private EditText etSomething;
    private Button btnFirst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindViews();

        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = etSomething.getText().toString();
                tvFirst.setText(data);
            }
        });
    }

    private void bindViews() {
        tvFirst = findViewById(R.id.tvFirst);
        etSomething = findViewById(R.id.etSomething);
        btnFirst = findViewById(R.id.btnFirst);
    }

    public void onSecondClicked(View view) {

        Toast.makeText(this,
                "Second button clicked",
                Toast.LENGTH_SHORT)
                .show();

        String url = "http://developer.android.com";
        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
        intent.putExtra("URL", url);
        startActivity(intent);



    }
}
