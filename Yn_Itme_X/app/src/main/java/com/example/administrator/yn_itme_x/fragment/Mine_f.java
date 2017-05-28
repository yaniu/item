package com.example.administrator.yn_itme_x.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.yn_itme_x.R;

/**
 * 作者：仝晓雅 on 2017/5/23 18:53
 * 类的注释：我的界面
 */

public class Mine_f extends Fragment {

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       if(view ==null){
           view = inflater.inflate(R.layout.mine_main, null);
           ViewGroup group = (ViewGroup) view.getParent();
           if(group!=null){
               group.removeView(view);
           }
       }
       // view = inflater.inflate(R.layout.mine_main, null);
        return view;
    }
}
