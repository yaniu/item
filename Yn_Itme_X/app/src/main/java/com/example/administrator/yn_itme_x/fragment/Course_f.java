package com.example.administrator.yn_itme_x.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;

import com.example.administrator.yn_itme_x.R;

/**
 * 作者：仝晓雅 on 2017/5/23 18:53
 * 类的注释：课程界面
 */

public class Course_f extends Fragment {

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(view==null){
            view = inflater.inflate(R.layout.course_main,null);
            ViewGroup parent = (ViewGroup) view.getParent();
            if(parent!=null){
                parent.removeView(view);
            }
        }
        //view = inflater.inflate(R.layout.course_main,null);
        return view;
    }
}
