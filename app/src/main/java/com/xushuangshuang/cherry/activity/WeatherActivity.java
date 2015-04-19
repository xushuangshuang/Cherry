package com.xushuangshuang.cherry.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.xushuangshuang.cherry.R;
import com.xushuangshuang.cherry.adapter.WeatherUserPageAdapter;

import java.util.ArrayList;

/**
 * Created by xuss on 2015/4/19.
 */
public class WeatherActivity extends Activity {

    private ImageView backGroundImageView;
    private ViewPager userViewPager;
    private LayoutInflater viewPageLayoutInflater;
    private ArrayList<View> views;
    private WeatherUserPageAdapter weatherUserPageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        initView();
    }

    private void initView(){
        setContentView(R.layout.weather_layout);
        viewPageLayoutInflater = LayoutInflater.from(this);
        backGroundImageView = (ImageView) findViewById(R.id.imageView_user_bg);
        userViewPager = (ViewPager) findViewById(R.id.viewPager_user);
        views = new ArrayList<View>();
        views.add(viewPageLayoutInflater.inflate(R.layout.weather_user_page,null));
        weatherUserPageAdapter = new WeatherUserPageAdapter(views);
        userViewPager.setAdapter(weatherUserPageAdapter);
    }
}
