package com.example.user.animation;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.renderscript.Sampler;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tvAnimate;
    private TextView tvTranslation;

    //    types of animation
    //property animation

    //view animation

    //drawable animation
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvAnimate = findViewById(R.id.tvAnimate);
        tvTranslation = findViewById(R.id.tvTranslation);

    }

    public void onAnimateTextView(View view) {

        switch (view.getId()) {
            case R.id.btnValueAnimator:

                ValueAnimator valueAnimator;
//        using the java code
//        valueAnimator = ValueAnimator.ofFloat(0f, 500f);
//        valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
//        valueAnimator.setDuration(2000);


//        using xml
                valueAnimator = (ValueAnimator) AnimatorInflater.loadAnimator(this, R.animator.value_animator_textview);

                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float progress = (float) valueAnimator.getAnimatedValue();
                        tvAnimate.setTranslationY(progress);
                        tvTranslation.setText(String.valueOf(progress));

                    }
                });

                valueAnimator.start();

                break;

            case R.id.btnObjectAnimator:

                ObjectAnimator objectAnimator = ObjectAnimator
                        .ofFloat(tvAnimate,
                                "translationY",
                                0f, 1000f);
                objectAnimator.setDuration(2000);
                objectAnimator.setInterpolator(new BounceInterpolator());
                objectAnimator.start();

                break;
        }


    }


    public void onTextViewClicked(View view) {

        Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show();
    }
}
