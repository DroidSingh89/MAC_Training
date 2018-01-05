package com.example.user.firebase.view.notification;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.user.firebase.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NotificationActivity extends AppCompatActivity {

    private static final String TAG = "NotificationActivityTag";
    @BindView(R.id.tvNotification)
    TextView tvNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        ButterKnife.bind(this);

        Log.d(TAG, "onCreate: ");

        String articleName = getIntent().getStringExtra("name");
        String articleId = getIntent().getStringExtra("id");


        tvNotification.setText(articleName + ":" + articleId);
    }
}
