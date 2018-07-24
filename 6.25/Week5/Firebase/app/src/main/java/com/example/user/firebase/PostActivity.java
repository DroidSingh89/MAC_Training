package com.example.user.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PostActivity extends AppCompatActivity {

    private TextView tvPostId;
    private TextView tvPostMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);


        tvPostId = findViewById(R.id.tvPostId);
        tvPostMessage = findViewById(R.id.tvPostMessage);

        String postId = getIntent().getStringExtra("postId");
        String postMessage = getIntent().getStringExtra("postMessage");

        tvPostId.setText(postId);
        tvPostMessage.setText(postMessage);

    }
}
