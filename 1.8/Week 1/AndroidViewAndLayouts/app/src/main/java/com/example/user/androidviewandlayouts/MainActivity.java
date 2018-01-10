package com.example.user.androidviewandlayouts;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private TextView firstTextView;
    private TextView secondTextView;
    private Button something;
    private Button somethingElse;
    private EditText etName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();

//        add listener for the button clicks
        something.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                firstTextView.setText(getText());
                Log.d(TAG, "onClick: ");
            }
        });
    }

    @NonNull
    private String getText() {
        return etName.getText().toString();
    }

    private void bindViews() {
        Log.d(TAG, "bindViews: ");
        firstTextView = findViewById(R.id.tvFirstTextView);
        secondTextView = findViewById(R.id.tvSecondTextView);
        something = findViewById(R.id.btnDoSomething);
        somethingElse = findViewById(R.id.btnDoSomethingElse);
        etName = findViewById(R.id.etName);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void onDoSomethingElse(View view) {
        Log.d(TAG, "onDoSomethingElse: ");
        secondTextView.setTextColor(getColor(R.color.colorAccent));
        secondTextView.setText(getText());
    }

    public void onShowWebView(View view) {

        Intent intent = new Intent(getApplicationContext(), WebViewActivity.class);
        startActivity(intent);

    }
}
