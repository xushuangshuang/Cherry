package com.xushuangshuang.cherry.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import com.xushuangshuang.cherry.R;
import com.xushuangshuang.cherry.fragment.LeftManageFragment;
import com.xushuangshuang.cherry.fragment.RightMyFragment;
import com.xushuangshuang.cherry.model.MainTab01;
import com.xushuangshuang.cherry.model.MainTab02;
import com.xushuangshuang.cherry.model.MainTab03;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends SlidingFragmentActivity {


    private ViewPager mViewPager;
    private FragmentPagerAdapter mAdapter;
    private List<Fragment> mFragments = new ArrayList<Fragment>();

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        // 初始化SlideMenu
        initRightMenu();
        // 初始化ViewPager
        initViewPager();

    }

    private void initViewPager()
    {
        mViewPager = (ViewPager) findViewById(R.id.id_viewpager);
        MainTab01 tab01 = new MainTab01();
        MainTab02 tab02 = new MainTab02();
        MainTab03 tab03 = new MainTab03();
        mFragments.add(tab01);
        mFragments.add(tab02);
        mFragments.add(tab03);
        /**
         * 初始化Adapter
         */
        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager())
        {
            @Override
            public int getCount()
            {
                return mFragments.size();
            }

            @Override
            public Fragment getItem(int arg0)
            {
                return mFragments.get(arg0);
            }
        };
        mViewPager.setAdapter(mAdapter);
    }

    private void initRightMenu()
    {

        Fragment leftMenuFragment = new LeftManageFragment();
        setBehindContentView(R.layout.manage_fragment_left);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.id_left_menu_frame, leftMenuFragment).commit();
        SlidingMenu menu = getSlidingMenu();
        menu.setMode(SlidingMenu.LEFT_RIGHT);
        // 设置触摸屏幕的模式
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
        menu.setShadowWidthRes(R.dimen.shadow_width);
        menu.setShadowDrawable(R.drawable.shadow);
        // 设置滑动菜单视图的宽度
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
//		menu.setBehindWidth()
        // 设置渐入渐出效果的值
        menu.setFadeDegree(0.35f);
        // menu.setBehindScrollScale(1.0f);
        menu.setSecondaryShadowDrawable(R.drawable.shadow);
        //设置右边（二级）侧滑菜单
        menu.setSecondaryMenu(R.layout.my_fragment_right);
        Fragment rightMenuFragment = new RightMyFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.id_right_menu_frame, rightMenuFragment).commit();
    }

    public void showLeftMenu(View view)
    {
        getSlidingMenu().showMenu();
    }

    public void showRightMenu(View view)
    {
        getSlidingMenu().showSecondaryMenu();
    }
}