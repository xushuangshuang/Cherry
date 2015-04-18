package com.xushuangshuang.cherry.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xushuangshuang.cherry.R;
import com.xushuangshuang.cherry.activity.WeatherActivity;


/**
 * Created by xuss on 2015/4/18.
 */
public class LeftManageFragment extends Fragment implements View.OnClickListener{

    private View mView;
    private TextView weatherTextView;
    private Intent skipIntent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (mView == null) {
            initView(inflater, container);
        }
        return mView;
    }

    private void initView(LayoutInflater inflater, ViewGroup container) {
        skipIntent = new Intent();
        mView = inflater.inflate(R.layout.manage_menu_left, container, false);
        weatherTextView = (TextView) mView.findViewById(R.id.weather_text_view);
        weatherTextView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.weather_text_view:
                skipIntent.setClass(getActivity(), WeatherActivity.class);
                startActivity(skipIntent);
                break;
        }

    }
}

