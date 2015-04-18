package com.xushuangshuang.cherry.adapter;

import android.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by xuss on 2015/4/18.
 */
public class MainViewPager extends PagerAdapter {

    private List<Fragment> fragments;
    public MainViewPager(List<Fragment> fragments){
        this.fragments = fragments;
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    /**
     * 此处不明白，但是官方说这样写，后面待学
     * @param view
     * @param object
     * @return
     */
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    //删除页
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }

    //添加页
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }
}
