package com.lxs.customview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button ratioCircle, skewRectangle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ratioCircle = (Button) findViewById(R.id.ratio_circle);
        skewRectangle = (Button) findViewById(R.id.skew_rectangle);

        ratioCircle.setOnClickListener(this);
        skewRectangle.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.ratio_circle:
                startActivity(new Intent(this, RatioCircleActivity.class));
                break;
            case R.id.skew_rectangle:
                startActivity(new Intent(this, SkewRectangleActivity.class));
                break;
        }

    }
}
