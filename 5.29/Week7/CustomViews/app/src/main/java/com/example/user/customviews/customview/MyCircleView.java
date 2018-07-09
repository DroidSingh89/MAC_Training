package com.example.user.customviews.customview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageItemInfo;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

import com.example.user.customviews.R;

public class MyCircleView extends View{

    int radius;
    int fillColor;
    private Paint paint;
    int width;
    int height;

    public MyCircleView(Context context) {
        super(context);
        init(context, null, 0, 0);

    }

    public MyCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0, 0);
    }

    public MyCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {

        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr, 0);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {

        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs, defStyleAttr, defStyleRes);
    }


    public void init(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {

        TypedArray typedArray =
                context.obtainStyledAttributes
                        (attrs, R.styleable.MyCircleView, defStyleAttr, defStyleRes);

        radius = typedArray.getInt(R.styleable.MyCircleView_radius, 40);
        fillColor = typedArray.getColor(R.styleable.MyCircleView_fillColor, getResources().getColor(android.R.color.black));


        paint = new Paint();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        paint.setColor(fillColor);

        int minDimen = Math.min(getHeight(), getWidth());
        radius = Math.min(minDimen/2, radius);

        canvas.drawCircle(width / 2, height / 2, radius, paint);


    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);


        int desiredHeight = 200;
        int desiredWidth = 200;

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
            width = Math.min(desiredWidth, widthSize);
        } else {
//            whatever we want
            width = desiredWidth;
        }



//        Measure height
        if (heightMode == MeasureSpec.EXACTLY) {
//            Must be this size
            height = heightSize;
        } else if (heightMode == MeasureSpec.AT_MOST) {
//            Can't be bigger than that
            height = Math.min(desiredHeight, heightSize);
        } else {
//            whatever we want
            height = desiredHeight;
        }

        setMeasuredDimension(width, height);

    }


    public void setRadius(int radius) {
        this.radius = radius;
        invalidate();

    }


    public void setFillColor(int color) {
        this.fillColor = color;
        invalidate();
    }



}



