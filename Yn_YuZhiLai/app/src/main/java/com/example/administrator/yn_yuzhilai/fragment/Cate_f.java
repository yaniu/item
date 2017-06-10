package com.example.administrator.yn_yuzhilai.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.yn_yuzhilai.R;
import com.example.administrator.yn_yuzhilai.activity.ClassActivity;
import com.example.administrator.yn_yuzhilai.activity.Xiang_Activity;
import com.example.administrator.yn_yuzhilai.activity.Xiang_JActivity;
import com.example.administrator.yn_yuzhilai.adpater.Study_rec;
import com.example.administrator.yn_yuzhilai.adpater.Study_rec_jing;
import com.example.administrator.yn_yuzhilai.adpater.Study_rec_ke;
import com.example.administrator.yn_yuzhilai.bean.CateGroyBean;
import com.example.administrator.yn_yuzhilai.bean.OneJingBean;
import com.example.administrator.yn_yuzhilai.bean.OneKeBean;
import com.example.administrator.yn_yuzhilai.bean.OneMianBean;
import com.example.administrator.yn_yuzhilai.bean.OnePicBean;
import com.example.administrator.yn_yuzhilai.s_mvp.persent.MyPresenters;
import com.example.administrator.yn_yuzhilai.s_mvp.view.MyView;
import com.example.administrator.yn_yuzhilai.tools.RecyclerViewDivider;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者：仝晓雅 on 2017/6/4 09:34
 * 类的注释：
 */

public class Cate_f extends BaseFragment implements MyView{


    @Bind(R.id.c_rec)
    RecyclerView cRec;
    private List<OneMianBean.DataBean.TryBean> mian_list = new ArrayList<>();
   /* private List<OneKeBean.DataBean.CourseBean> course;
    private List<OneJingBean.DataBean.TopicBean> topic;*/


    @Override
    public View initView(LayoutInflater inflater) {
        View view = inflater.inflate(R.layout.cla_f, null);
        new MyPresenters(getActivity(),this).showDataBeann();
        return view;
    }

    @Override
    public void initData(Bundle savedInstanceState) {


    }
    @OnClick(R.id.c_rec)
    public void onViewClicked() {
    }

    @Override
    public void showBanner(OnePicBean onePicBean) {

    }

    @Override
    public void showMian(OneMianBean oneMianBean) {
        List<OneMianBean.DataBean.TryBean> tryX = oneMianBean.getData().getTryX();
        for (int i = 0; i < tryX.size(); i++) {
            mian_list.add(tryX.get(i));
        }
        //添加分割线
        cRec.addItemDecoration(new RecyclerViewDivider(
                getActivity(), RecyclerViewDivider.VERTICAL_LIST));
        cRec.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        Study_rec rec1 = new Study_rec(getActivity(), mian_list);

        rec1.setOnItemClickListener(new Study_rec.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent =new Intent(getActivity(),Xiang_Activity.class);
                intent.putExtra("position",position);
                startActivityForResult(intent,30);
            }
        });
        cRec.setAdapter(rec1);

    }

    @Override
    public void showKe(OneKeBean oneKeBean) {
       /* course = oneKeBean.getData().getCourse();
        //添加分割线
        cRec.addItemDecoration(new RecyclerViewDivider(
                getActivity(), RecyclerViewDivider.VERTICAL_LIST));
        cRec.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        //Study_rec rec1 = new Study_rec(getActivity(), mian_list);
        Study_rec_ke ke = new Study_rec_ke(getActivity(), course);
        ke.setOnItemClickListener(new Study_rec_ke.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent =new Intent(getActivity(),Xiang_Activity.class);
                intent.putExtra("position",position);
                startActivityForResult(intent,30);
            }
        });
        cRec.setAdapter(ke);*/
    }

    @Override
    public void showZhuan(OneJingBean oneJingBean) {
        /*topic = oneJingBean.getData().getTopic();
        cRec.setLayoutManager(new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false));
        // sRecZhaun.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        //添加分割线
        cRec.addItemDecoration(new RecyclerViewDivider(
                getActivity(), RecyclerViewDivider.HORIZONTAL_LIST));
        cRec.addItemDecoration(new RecyclerViewDivider(
                getActivity(), RecyclerViewDivider.VERTICAL_LIST));
        Study_rec_jing jing = new Study_rec_jing(getActivity(), topic);
        jing.setOnItemClickListener(new Study_rec_jing.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent =new Intent(getActivity(),Xiang_JActivity.class);
                intent.putExtra("position",position);
                startActivityForResult(intent,20);
            }
        });
        cRec.setAdapter(jing);*/
    }

    @Override
    public void showCateTab(CateGroyBean cateGroyBean) {

    }
}
