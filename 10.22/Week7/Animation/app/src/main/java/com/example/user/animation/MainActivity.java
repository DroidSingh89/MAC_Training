package com.example.user.animation;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

    private TextView tvAnimate;
    private float translationY;
    private float translationX;
    private float translationZ;
    private TextView tvTranslation;
    private float rotation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvAnimate = findViewById(R.id.tvAnimate);
        tvTranslation = findViewById(R.id.tvTranslation);
        translationY = 0f;
        translationX = 0f;
        translationZ = 0f;

        rotation = 0f;
    }

    public void animateTextView(View view) {


//        translationY
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(translationY, translationY+500f);
        valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimator.setDuration(5000);

        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                translationY = (float) animation.getAnimatedValue();
                tvAnimate.setTranslationY(translationY);

            }
        });



//        translationY
        ValueAnimator valueAnimatorX = ValueAnimator.ofFloat(translationX, translationX+500f);
        valueAnimatorX.setInterpolator(new BounceInterpolator());
        valueAnimatorX.setDuration(5000);

        valueAnimatorX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                translationX = (float) animation.getAnimatedValue();
                tvAnimate.setTranslationX(translationX);


            }
        });


//        translationZ
        ValueAnimator valueAnimatorZ = ValueAnimator.ofFloat(translationZ, translationZ-500f);
        valueAnimatorZ.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimatorZ.setDuration(5000);

        valueAnimatorZ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                translationZ = (float) animation.getAnimatedValue();

                tvAnimate.setTranslationZ(translationZ);
                tvTranslation.setText(String.valueOf(translationY));


            }
        });

        valueAnimator.start();
        valueAnimatorX.start();
        valueAnimatorZ.start();



        rotation += 90f;
        tvAnimate.animate().rotation(rotation).setDuration(5000).start();
    }

    public void onTextViewClick(View view) {
        Toast.makeText(this, "Click", Toast.LENGTH_SHORT).show();
    }

    public void onTranslationClick(View view) {
        Toast.makeText(this, "Translation", Toast.LENGTH_SHORT).show();
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, Main2Activity.class);
        context.startActivity(starter);
    }
    public void startActivity(View view) {
        start(this);
    }
}
