package com.xushuangshuang.cherry.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xushuangshuang.cherry.R;

/**
 * Created by xuss on 2015/4/18.
 */
public class RightMyFragment extends Fragment {
    private View mView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        if(mView == null)
        {
            mView = inflater.inflate(R.layout.my_menu_right, container, false);
        }
        return mView ;
    }
}
