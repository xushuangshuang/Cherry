package com.xushuangshuang.cherry.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.xushuangshuang.cherry.R;

import java.util.Arrays;
import java.util.List;

/**
 * Created by xuss on 2015/4/18.
 */
public class LeftManageFragment extends Fragment {

    private View mView;
    private ListView mCategories;
    private List<String> mDatas = Arrays
            .asList("聊天", "发现", "通讯录", "朋友圈", "订阅号");
    private ListAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (mView == null) {
            initView(inflater, container);
        }
        return mView;
    }

    private void initView(LayoutInflater inflater, ViewGroup container) {
        mView = inflater.inflate(R.layout.manage_menu_left, container, false);
        mCategories = (ListView) mView
                .findViewById(R.id.id_listview_categories);
        mAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, mDatas);
        mCategories.setAdapter(mAdapter);
    }
}

