package com.example.user.firebase.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.user.firebase.R;

public class ArticleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        TextView textView = findViewById(R.id.tvArticle);
        textView.setText(getIntent().getStringExtra("articleID"));

    }
}
