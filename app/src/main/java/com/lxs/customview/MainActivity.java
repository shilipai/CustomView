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
        setContentView(R.layout.activity_main);
        mRatioCircleView = (RatioCircleView) findViewById(R.id.ratio_circle_view);
        mRatioCircleDatas = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            mRatioCircleDatas.add(new RatioCircleData(i + "", i));
        }
        mRatioCircleView.setData(mRatioCircleDatas);
    }
}
