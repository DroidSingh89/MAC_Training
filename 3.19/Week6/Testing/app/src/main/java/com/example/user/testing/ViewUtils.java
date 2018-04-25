package com.example.user.testing;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ViewUtils {

    public static String getString(View view) {
        if (view instanceof EditText) {
            EditText editText = (EditText) view;
            return editText.getText().toString();
        }
        return null;
    }

    public static void setText(TextView text, EditText editText) {
        text.setText(editText.getText().toString());

    }
}
