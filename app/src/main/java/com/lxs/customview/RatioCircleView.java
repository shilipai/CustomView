package com.lxs.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

/**
 * 实现功能：
 * 作    者：xinsheng.lv
 * 创建日期：2016年09月21日 22:31
 * 修 改 者：修改日期：修改内容：
 */
public class RatioCircleView extends View {
    // 颜色表 (注意: 此处定义颜色使用的是ARGB，带Alpha通道的)
    private int[] mColors = {0xFFCCFF00, 0xFF6495ED, 0xFFE32636, 0xFF800000, 0xFF808000, 0xFFFF8C69, 0xFF808080,
            0xFFE6B800, 0xFF7CFC00};
    // 饼状图初始绘制角度
    private float mStartAngle = 0;
    // 数据
    private ArrayList<RatioCircleData> mData;
    // 宽高
    private int mWidth, mHeight;
    // 画笔
    private Paint mPaint = new Paint();

    public RatioCircleView(Context context) {
        this(context, null);
    }

    public RatioCircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (null == mData)
            return;
        float currentStartAngle = mStartAngle;                    // 当前起始角度
        canvas.translate(mWidth / 2, mHeight / 2);                // 将画布坐标原点移动到中心位置
        float r = (float) (Math.min(mWidth, mHeight) / 2 * 0.8);  // 饼状图半径
        RectF rect = new RectF(-r, -r, r, r);                     // 饼状图绘制区域

        for (int i = 0; i < mData.size(); i++) {
            RatioCircleData ratioCircleData = mData.get(i);
            mPaint.setColor(ratioCircleData.getColor());
            canvas.drawArc(rect, currentStartAngle, ratioCircleData.getAngle(), true, mPaint);
            currentStartAngle += ratioCircleData.getAngle();
        }

    }

    // 设置起始角度
    public void setStartAngle(int mStartAngle) {
        this.mStartAngle = mStartAngle;
        invalidate();   // 刷新
    }

    // 设置数据
    public void setData(ArrayList<RatioCircleData> mData) {
        this.mData = mData;
        initDate(mData);
        invalidate();   // 刷新
    }

    // 初始化数据
    private void initDate(ArrayList<RatioCircleData> mData) {
        if (null == mData || mData.size() == 0)   // 数据有问题 直接返回
            return;

        float sumValue = 0;
        for (int i = 0; i < mData.size(); i++) {
            RatioCircleData ratioCircleData = mData.get(i);

            sumValue += ratioCircleData.getValue();       //计算数值和

            int j = i % mColors.length;       //设置颜色
            ratioCircleData.setColor(mColors[j]);
        }

//        float sumAngle = 0;
        for (int i = 0; i < mData.size(); i++) {
            RatioCircleData ratioCircleData = mData.get(i);

            float percentage = ratioCircleData.getValue() / sumValue;   // 百分比
            float angle = percentage * 360;                 // 对应的角度

            ratioCircleData.setPercentage(percentage);                  // 记录百分比
            ratioCircleData.setAngle(angle);                            // 记录角度大小
//            sumAngle += angle;

            Log.i("angle", "" + ratioCircleData.getAngle());
        }
    }
}

