package com.lxs.customview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

/**
 * 实现功能：
 * <p/>
 * Created by lxs on 2016/9/23 16:49.
 * 修 改 者：修改日期：修改内容：
 */
public class RatioCircleActivity extends AppCompatActivity {

    private RatioCircleView mRatioCircleView;
    private ArrayList<RatioCircleData> mRatioCircleDatas;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratio_circle);
        mRatioCircleDatas = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            mRatioCircleDatas.add(new RatioCircleData(String.valueOf(i), i));
        }
        mRatioCircleView = (RatioCircleView) findViewById(R.id.ratio_circle_view);
        mRatioCircleView.setData(mRatioCircleDatas);
    }
}
