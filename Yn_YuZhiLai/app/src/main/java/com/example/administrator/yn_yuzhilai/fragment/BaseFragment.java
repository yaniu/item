package com.example.administrator.yn_yuzhilai.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * 类的用途：
 * 作者：仝晓雅
 * 时间： 2017/5/15 09:27
 */

public abstract class BaseFragment extends Fragment {
    public View view;
    public Context context;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData(savedInstanceState);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();
    }

    /**
     * setContentView;
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = initView(inflater);
        ButterKnife.bind(this, view);
        return view;
    }

    public View getRootView() {

        return view;
    }

    /**
     * 初始化view
     */
    public abstract View initView(LayoutInflater inflater);

    /**
     * 初始化数据
     */
    public abstract void initData(Bundle savedInstanceState);

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
