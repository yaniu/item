package com.example.administrator.yn_yuzhilai.adpater;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.administrator.yn_yuzhilai.activity.MainActivity;

import java.util.ArrayList;

/**
 * 作者：仝晓雅 on 2017/6/2 09:56
 * 类的注释：引导页的适配器
 */

public class MyPager extends PagerAdapter {
    private Context context;
    private ArrayList<ImageView> list;
    public MyPager(Context context, ArrayList<ImageView> list) {
        this.context=context;
        this.list=list;
    }

    @Override
    public int getCount() {

        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
       container.addView(list.get(position%list.size()));
        return list.get(position%list.size());
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
       container.removeView(list.get(position%list.size()));
    }
}
