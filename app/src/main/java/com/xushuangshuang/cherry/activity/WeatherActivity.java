package com.xushuangshuang.cherry.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import com.xushuangshuang.cherry.R;

/**
 * Created by xuss on 2015/4/19.
 */
public class WeatherActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.weather_layout);
    }
}
