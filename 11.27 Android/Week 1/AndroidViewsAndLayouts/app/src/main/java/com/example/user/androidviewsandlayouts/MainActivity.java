package com.example.user.androidviewsandlayouts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    TextView tvFullNameLL;
    TextView tvFirstNameRL;
    TextView tvLastNameRL;
    TextView tvFullNameRL;
    TextView tvFullNameFL;

    EditText etFirstName;
    EditText etLastName;

    Button btnSetName;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvFullNameLL = findViewById(R.id.tvFullName_ll);
        tvFirstNameRL = findViewById(R.id.tvFirstName_rl);

        etFirstName = findViewById(R.id.etFirstName);
        etLastName= findViewById(R.id.etLastName);

        btnSetName = findViewById(R.id.btnSetName);

        btnSetName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName = etFirstName.getText().toString();
                String lastName = etLastName.getText().toString();

                tvFullNameLL.setText(firstName + " " + lastName);

            }
        });


    }
}
