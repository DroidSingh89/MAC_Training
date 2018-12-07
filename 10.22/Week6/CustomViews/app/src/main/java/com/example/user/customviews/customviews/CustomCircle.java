package com.example.user.customviews.customviews;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import com.example.user.customviews.R;

import java.util.Random;

public class CustomCircle extends View implements View.OnClickListener{


    public static final int MIN_WIDTH = 200;
    public static final int MIN_HEIGHT = 200;
    private static final String TAG = CustomCircle.class.getSimpleName() + "_TAG";
    private int radius;
    private int fillColor;
    private int cx;
    private int cy;
    private int width;
    private int height;


    private Paint paint;

    @RequiresApi(api = Build.VERSION_CODES.M)
    public CustomCircle(Context context) {
        super(context);
        init(context, null, 0, 0);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public CustomCircle(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0, 0);

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public CustomCircle(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr, 0);
    }

    @TargetApi(Build.VERSION_CODES.M)
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustomCircle(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, null, 0, 0);
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    @SuppressLint("ResourceType")
    public void init(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomCircle, defStyleAttr, defStyleRes);
        radius = typedArray.getInt(R.styleable.CustomCircle_radius, 50);
        fillColor = typedArray.getColor(R.styleable.CustomCircle_fillColor, 0);
        paint = new Paint();


        typedArray.recycle();
        setOnClickListener(this);
    }

    private void calculateCircle() {
        cx = width / 2;
        cy = height / 2;

        int minDim = Math.min(width, height) / 2;
        radius = Math.min(minDim, radius);
        paint.setColor(fillColor);

    }

    private void updateRandomColor() {
        paint.setARGB(255, getRandomInt(), getRandomInt(), getRandomInt());

    }

    private int getRandomInt() {
        return new Random().nextInt(255);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(cx, cy, radius, paint);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);


        //get mode and value
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);


//        Measure width

        if (widthMode == MeasureSpec.EXACTLY) {
//            Must be this size
            width = widthSize;
        } else if (widthMode == MeasureSpec.AT_MOST) {
//            Can't be bigger than that
            width = Math.min(MIN_WIDTH, widthSize);
        } else {
//            whatever we want
            width = MIN_WIDTH;
        }


//        Measure height
        if (heightMode == MeasureSpec.EXACTLY) {
//            Must be this size
            height = heightSize;
        } else if (heightMode == MeasureSpec.AT_MOST) {
//            Can't be bigger than that
            height = Math.min(MIN_HEIGHT, heightSize);
        } else {
//            whatever we want
            height = MIN_HEIGHT;
        }

        calculateCircle();
        setMeasuredDimension(width, height);

    }

    public void setRadius(int radius) {
        this.radius = radius;
        calculateCircle();
        invalidate();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onClick(View v) {
        updateRandomColor();
        invalidate();
    }

}
