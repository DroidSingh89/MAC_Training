package com.example.user.customviews.customviews;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class CustomButton extends AppCompatButton implements View.OnClickListener{

    private static final String TAG = CustomButton.class.getSimpleName()+ "_TAG";
    onClickListener listener;
    Context context;
    public CustomButton(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public CustomButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }


    private void init() {
        setOnClickListener(this);
    }

    public void setCustomClickListener(Object object) {
        listener = (onClickListener) object;
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(context, "Fetching result", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onClick: "+ "Fetching result");
        //any logic for the button click
        listener.customOnClick("Value from custom button");
    }


    //callback to listen to button click
    public interface onClickListener{
        void customOnClick(String customValue);
    }
}
