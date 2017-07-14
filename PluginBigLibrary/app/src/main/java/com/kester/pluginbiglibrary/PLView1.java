package com.kester.pluginbiglibrary;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by kester on 2017/7/14.
 */
public class PLView1 extends View {
    public PLView1(Context context) {
        super(context, null);
    }

    public PLView1(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    Paint mPaint;
    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.rgb(77, 77, 77));
        mPaint.setAntiAlias(true);
        mPaint.setTextSize(30);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        init();
        canvas.drawRect(0, 0, getWidth(), getHeight(), mPaint);
        mPaint.setColor(Color.rgb(255, 255, 255));
        String text = "View From PluginBigLibrary";
        TextPaint tp = new TextPaint();
        int halfWidth = (int) tp.measureText(text);
        canvas.drawText("View From PluginBigLibrary", getWidth()/2-halfWidth, getHeight()/2 ,mPaint);
    }
}
