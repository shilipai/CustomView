package com.lxs.customview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RatioCircleView mRatioCircleView;
    ArrayList<RatioCircleData> mRatioCircleDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRatioCircleView = new RatioCircleView(this);
//        setContentView(R.layout.activity_main);
        setContentView(mRatioCircleView);
//        mRatioCircleView = (RatioCircleView) findViewById(R.id.ratio_circle_view);
        mRatioCircleDatas = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            mRatioCircleDatas.add(new RatioCircleData(String.valueOf(i), i));
        }
        mRatioCircleView.setData(mRatioCircleDatas);
    }
}
