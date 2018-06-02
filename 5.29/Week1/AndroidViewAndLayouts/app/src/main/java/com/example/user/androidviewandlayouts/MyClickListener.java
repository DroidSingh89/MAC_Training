package com.example.user.androidviewandlayouts;

import android.view.View;
import android.widget.TextView;

public class MyClickListener implements View.OnClickListener {

    TextView textView;

    public MyClickListener(TextView textView) {
        this.textView = textView;
    }

    @Override
    public void onClick(View view) {

        textView.setText(getTextValue());
    }

    private String getTextValue() {
        return "Some Value";
    }

}
