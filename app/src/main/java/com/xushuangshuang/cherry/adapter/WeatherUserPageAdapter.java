package com.xushuangshuang.cherry.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;

import java.util.List;

/**
 * Created by xuss on 2015/4/19.
 */
public class WeatherUserPageAdapter  extends PagerAdapter{

    private List<View> viewList;
    public WeatherUserPageAdapter(List<View> viewList){
        this.viewList = viewList;
    }

    @Override
    public int getCount() {
        return viewList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
