package com.example.user.customviews.customviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.example.user.customviews.R;

import static android.content.ContentValues.TAG;

/**
 * Created by singh on 12/12/17.
 */

public class CustomCircle extends View {

    Context context;
    int radius;
    int fillColor;
    int width, height;


    public CustomCircle(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;

        TypedArray typedArray =
                context.obtainStyledAttributes(attrs, R.styleable.custom_circle, 0, 0);

//        initialize the attributes obtained from the layout xml
        radius = typedArray.getInt(R.styleable.custom_circle_radius, 20);
        fillColor = typedArray.getColor(R.styleable.custom_circle_fillColor, 0);

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setColor(fillColor);

//        limit radius
        if (radius > width / 2)
            radius = width / 2;

        Log.d(TAG, "onDraw: " + radius);
        canvas.drawCircle(width / 2, height / 2, radius, paint);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int desiredWidth = 300;
        int desiredHeight = 300;

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);


        //Measure Width
        if (widthMode == MeasureSpec.EXACTLY) {
            //Must be this size
            width = widthSize;
        } else if (widthMode == MeasureSpec.AT_MOST) {
            //Can't be bigger than...
            width = Math.min(desiredWidth, widthSize);
        } else {
            //Be whatever you want
            width = desiredWidth;
        }

        //Measure Height
        if (heightMode == MeasureSpec.EXACTLY) {
            //Must be this size
            height = heightSize;
        } else if (heightMode == MeasureSpec.AT_MOST) {
            //Can't be bigger than...
            height = Math.min(desiredHeight, heightSize);
        } else {
            //Be whatever you want
            height = desiredHeight;
        }
        setMeasuredDimension(width, height);


    }

    public int getRadius() {

        return radius;

    }

    public void setRadius(int radius) {

        this.radius = radius;
        invalidate();
        requestLayout();

    }

    public int getFillColor() {
        return fillColor;
    }

    public void setFillColor(int fillColor) {

        this.fillColor = fillColor;
        invalidate();
        requestLayout();

    }
}
