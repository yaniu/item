package com.example.administrator.yn_itme_x.fragment_s;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.yn_itme_x.R;
import com.example.administrator.yn_itme_x.apdate.Study_rec;

/**
 * 作者：仝晓雅 on 2017/5/25 13:50
 * 类的注释：
 */

public class Fragmnets extends Fragment {
    private RecyclerView f_rec;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragments_main, null);
        initView(view);
        return view;
    }

    private void initView(View view) {
       /* f_rec = (RecyclerView) view.findViewById(R.id.f_rec);
        f_rec.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
      *//*  Study_rec rec1 =new Study_rec(getActivity());
        f_rec.setAdapter(rec1);*/
    }
}
