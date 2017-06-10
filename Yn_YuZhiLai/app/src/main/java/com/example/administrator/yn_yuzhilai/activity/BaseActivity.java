package com.example.administrator.yn_yuzhilai.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * 作者：仝晓雅 on 2017/6/2 16:56
 * 类的注释：
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        ButterKnife.bind(this);
        initView();
        getData();
    }
    public abstract int initLayout();
    public abstract void initView();
    public abstract void getData();

}
