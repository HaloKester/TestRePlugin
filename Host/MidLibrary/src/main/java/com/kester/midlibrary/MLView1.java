package com.kester.midlibrary;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

/**
 * Created by kester on 2017/7/14.
 */
public class MLView1 extends View {
    private String mTitleText = "";
    private int mTitleTextColor;
    private int mTitleTextSize;
    private Paint mPaint;
    private Rect mBound;

    public MLView1(Context context) {
        this(context, null);
    }

    public MLView1(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustomTitleView);
        int n = a.getIndexCount();
        for (int i = 0; i < n; i++) {
            int attr = a.getIndex(i);
            if (attr == R.styleable.CustomTitleView_titleText) {
                mTitleText = a.getString(attr);
            } else if (attr == R.styleable.CustomTitleView_titleTextColor) {
                mTitleTextColor = a.getColor(attr, Color.GREEN);
            } else if (attr == R.styleable.CustomTitleView_titleTextSize) {
                mTitleTextSize = a.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics()));
            }
        }
        a.recycle();

        mPaint = new Paint();
        mPaint.setTextSize(mTitleTextSize);
        mBound = new Rect();
        mPaint.getTextBounds(mTitleText, 0, mTitleText.length(), mBound);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        mPaint.setColor(Color.YELLOW);
        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), mPaint);
        mPaint.setColor(mTitleTextColor);
        canvas.drawText(mTitleText, getWidth()/2-mBound.width()/2, getHeight()/2, mPaint);
    }
}
