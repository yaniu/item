package com.example.administrator.yn_yuzhilai.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.example.administrator.yn_yuzhilai.R;
import com.example.administrator.yn_yuzhilai.activity.Class1Activity;
import com.example.administrator.yn_yuzhilai.activity.Class2Activity;
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
import com.example.administrator.yn_yuzhilai.tools.MyImager;
import com.example.administrator.yn_yuzhilai.tools.RecyclerViewDivider;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 作者：仝晓雅 on 2017/5/23 18:53
 * 类的注释：学习界面
 */

public class Study_f extends BaseFragment implements MyView {


    @Bind(R.id.s_banner)
    Banner sBanner;
    @Bind(R.id.s_lin_mian)
    LinearLayout sLinMian;
    @Bind(R.id.s_rec_mian)
    RecyclerView sRecMian;
    @Bind(R.id.s_lin_ke)
    LinearLayout sLinKe;
    @Bind(R.id.s_rec_ke)
    RecyclerView sRecKe;
    @Bind(R.id.s_lin_zhuan)
    LinearLayout sLinZhuan;
    @Bind(R.id.s_rec_zhaun)
    RecyclerView sRecZhaun;
    private MyPresenters myPresenters;
    private List<OneMianBean.DataBean.TryBean> mian_list = new ArrayList<>();
    private List<OneKeBean.DataBean.CourseBean> course;
    private List<OneJingBean.DataBean.TopicBean> topic;

    @Override
    public View initView(LayoutInflater inflater) {
        View view = inflater.inflate(R.layout.s_main, null);
        myPresenters = new MyPresenters(getActivity(), this);
        myPresenters.showDataBeann();
        return view;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
     /*   sRecMian.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        //Study_rec rec1 =new Study_rec(getActivity(),mian_list);
        Study_rec rec1 =new Study_rec();
        sRecMian.setAdapter(rec1);
        sRecKe.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        //Study_rec rec1 =new Study_rec(getActivity(),mian_list);
        Study_rec rec1 =new Study_rec();
        sRecKe.setAdapter(rec1);
        sRecZhaun.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        //Study_rec rec1 =new Study_rec(getActivity(),mian_list);
        Study_rec rec1 =new Study_rec();
        sRecZhaun.setAdapter(rec1);*/
    }

    @OnClick({R.id.s_banner, R.id.s_lin_mian, R.id.s_rec_mian, R.id.s_lin_ke, R.id.s_rec_ke, R.id.s_lin_zhuan, R.id.s_rec_zhaun})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.s_banner:
                break;
            case R.id.s_lin_mian:
                Intent intent =new Intent(getActivity(),ClassActivity.class);
                intent.putExtra("name","免费课程");


                startActivityForResult(intent,10);


                break;
            case R.id.s_rec_mian:
                break;
            case R.id.s_lin_ke:
                Intent intent1 =new Intent(getActivity(),Class1Activity.class);
                intent1.putExtra("name","精选课程");


                startActivityForResult(intent1,10);
                break;
            case R.id.s_rec_ke:
                break;
            case R.id.s_lin_zhuan:
                Intent intent2 =new Intent(getActivity(),Class2Activity.class);
                intent2.putExtra("name","精选专辑");

                startActivityForResult(intent2,10);
                break;
            case R.id.s_rec_zhaun:
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==10&&requestCode==20){

        }
    }

    @Override
    public void showBanner(OnePicBean onePicBean) {
        List<OnePicBean.DataBean.BannerBean> banner = onePicBean.getData().getBanner();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < banner.size(); i++) {
            list.add(banner.get(i).getImage());
        }
        //设置banner样式
        sBanner.setBannerStyle(BannerConfig.NUM_INDICATOR);
        //设置图片加载器
        sBanner.setImageLoader(new MyImager());
        //设置图片集合
        sBanner.setImages(list);
        //banner设置方法全部调用完毕时最后调用
        sBanner.start();
    }

    //免费课程
    @Override
    public void showMian(OneMianBean oneMianBean) {
        List<OneMianBean.DataBean.TryBean> tryX = oneMianBean.getData().getTryX();
        for (int i = 0; i < tryX.size(); i++) {
            mian_list.add(tryX.get(i));
        }
        //添加分割线
        sRecMian.addItemDecoration(new RecyclerViewDivider(
                getActivity(), RecyclerViewDivider.VERTICAL_LIST));
        sRecMian.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        Study_rec rec1 = new Study_rec(getActivity(), mian_list);

        rec1.setOnItemClickListener(new Study_rec.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent =new Intent(getActivity(),Xiang_Activity.class);
                intent.putExtra("position",position);
                intent.putExtra("mai","免费试看");
                /*intent.putExtra("flag",true);*/

                startActivityForResult(intent,30);
            }
        });
        sRecMian.setAdapter(rec1);

    }

    @Override
    public void showKe(OneKeBean oneKeBean) {
        course = oneKeBean.getData().getCourse();
        //添加分割线
        sRecKe.addItemDecoration(new RecyclerViewDivider(
                getActivity(), RecyclerViewDivider.VERTICAL_LIST));
        sRecKe.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        //Study_rec rec1 = new Study_rec(getActivity(), mian_list);
        Study_rec_ke ke = new Study_rec_ke(getActivity(), course);
        ke.setOnItemClickListener(new Study_rec_ke.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position,int price) {
                Intent intent =new Intent(getActivity(),Xiang_Activity.class);
                intent.putExtra("position",position);
                intent.putExtra("mai","立即购买");
                intent.putExtra("price",price);
                startActivityForResult(intent,30);
            }
        });
        sRecKe.setAdapter(ke);
    }

    @Override
    public void showZhuan(OneJingBean oneJingBean) {
        topic = oneJingBean.getData().getTopic();
        sRecZhaun.setLayoutManager(new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false));
      // sRecZhaun.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        //添加分割线
        sRecZhaun.addItemDecoration(new RecyclerViewDivider(
                getActivity(), RecyclerViewDivider.HORIZONTAL_LIST));
        sRecZhaun.addItemDecoration(new RecyclerViewDivider(
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
        sRecZhaun.setAdapter(jing);


    }

    @Override
    public void showCateTab(CateGroyBean cateGroyBean) {

    }
}
