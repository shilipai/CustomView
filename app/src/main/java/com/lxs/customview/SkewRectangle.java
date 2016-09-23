package com.lxs.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * 实现功能：
 * <p/>
 * Created by lxs on 2016/9/22 17:40.
 * 修 改 者：修改日期：修改内容：
 */
public class SkewRectangle extends View {

    private Paint mPaint;
    private float mWidth, mHeight;

    public SkewRectangle(Context context) {
        this(context, null);
    }

    public SkewRectangle(Context context, AttributeSet attrs) {

        super(context, attrs);
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(10);
        mPaint.setAntiAlias(true);
        mWidth = getResources().getDisplayMetrics().widthPixels;
        mHeight = getResources().getDisplayMetrics().heightPixels;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.translate(mWidth / 2, mHeight / 2);

        RectF rect = new RectF(0, 0, 200, 200);   // 矩形区域

        mPaint.setColor(Color.BLACK);           // 绘制黑色矩形
        canvas.drawRect(rect, mPaint);

        canvas.skew(0, 1);                       // 垂直错切
        canvas.skew(1, 0);                       // 水平错切
        mPaint.setColor(Color.BLUE);            // 绘制蓝色矩形
        canvas.drawRect(rect, mPaint);
    }
}
