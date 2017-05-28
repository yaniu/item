package com.example.administrator.yn_itme_x.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.yn_itme_x.R;
import com.example.administrator.yn_itme_x.activity.NextActivity;
import com.example.administrator.yn_itme_x.activity.XiangActivity;
import com.example.administrator.yn_itme_x.activity.Xiang_KActivity;
import com.example.administrator.yn_itme_x.apdate.Study_rec;
import com.example.administrator.yn_itme_x.apdate.Study_rec_jing;
import com.example.administrator.yn_itme_x.apdate.Study_rec_ke;
import com.example.administrator.yn_itme_x.bean.OneJingBean;
import com.example.administrator.yn_itme_x.bean.OneKeBean;
import com.example.administrator.yn_itme_x.bean.OneMianBean;
import com.example.administrator.yn_itme_x.study.S_MyPersent;
import com.example.administrator.yn_itme_x.study.S_view;
import com.example.administrator.yn_itme_x.utilus.BannerImageLoader;
import com.example.administrator.yn_itme_x.utilus.OnePicBean;
import com.example.administrator.yn_itme_x.utilus.RecyclerViewDivider;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者：仝晓雅 on 2017/5/23 18:53
 * 类的注释：学习界面
 */

public class Study_f extends Fragment implements S_view{

    @Bind(R.id.s_banner)
    Banner sBanner;
    @Bind(R.id.s_text1)
    TextView sText1;
    @Bind(R.id.s_mian)
    RecyclerView sMian;
    @Bind(R.id.s_text2)
    TextView sText2;
    @Bind(R.id.s_jing)
    RecyclerView sJing;
    @Bind(R.id.s_text3)
    TextView sText3;
    @Bind(R.id.s_zhuan)
    RecyclerView sZhuan;
    private View view;
    private S_MyPersent persent;
    private ArrayList<String> list =new ArrayList<>();
    private List<OneMianBean.DataBean.TryBean>  mian_list =new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.study_main, null);
            ViewGroup parent = (ViewGroup) view.getParent();
            if (parent != null) {
                parent.removeView(view);
            }
        }
        // view = inflater.inflate(R.layout.study_main, null);
        ButterKnife.bind(this, view);

        persent = new S_MyPersent(getActivity(),this);
        getdata();

        return view;
    }



    private void getdata() {
        //调用数据的方法
        //轮播图片
        persent.showListBannerToView();
        //免费列表
        persent.showListMianToView();
        //精选课程
        persent.showListKeToView();
        //精选专辑
        persent.showListJingToView();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.s_banner, R.id.s_text1, R.id.s_mian, R.id.s_text2, R.id.s_jing, R.id.s_text3, R.id.s_zhuan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.s_banner:


                break;
            case R.id.s_text1:
                Intent intent =new Intent(getActivity(),NextActivity.class);
                intent.putExtra("name","免费试听");

               startActivityForResult(intent,10);
                break;
            case R.id.s_mian:

                break;
            case R.id.s_text2:
                Intent intent1 =new Intent(getActivity(),NextActivity.class);
                intent1.putExtra("name","精选课程");
                intent1.putExtra("time",true);
                startActivityForResult(intent1,10);
                break;
            case R.id.s_jing:

                break;
            case R.id.s_text3:
                Intent intent2 =new Intent(getActivity(),NextActivity.class);
                intent2.putExtra("name","精选专辑");
                startActivityForResult(intent2,10);
                break;
            case R.id.s_zhuan:

                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==10&&resultCode==20){
        }
        if(requestCode==20&&resultCode==30){

        }
    }

    @Override
    public void showBanner(OnePicBean onePicBean) {
        OnePicBean.DataBean data = onePicBean.getData();
        List<OnePicBean.DataBean.BannerBean> lists = data.getBanner();
       if(lists!=null){
           for(int i =0;i<lists.size();i++){
               String image = lists.get(i).getImage();
               list.add(image);
               Log.i("list",lists.get(i).getClick());
           }
       }
        //设置图片加载器
        sBanner.setImageLoader(new BannerImageLoader());
       //设置图片集合
        sBanner.setImages(list);
      //banner设置方法全部调用完毕时最后调用
        sBanner.start();


    }


    //免费列表
    @Override
    public void showMina(OneMianBean mianBeen) {
        List<OneMianBean.DataBean.TryBean> tryX = mianBeen.getData().getTryX();

       for(int i =0;i<tryX.size();i++){
           mian_list.add(tryX.get(i));
       }
        sMian.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        Study_rec rec1 =new Study_rec(getActivity(),mian_list);
        sMian.addItemDecoration(new RecyclerViewDivider(getActivity(),LinearLayoutManager.VERTICAL,10, Color.parseColor("#c2b8b8")));
        rec1.setOnItemClickListener(new Study_rec.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent =new Intent(getActivity(),Xiang_KActivity.class);
                intent.putExtra("position",position);
                startActivityForResult(intent,30);
            }
        });
        sMian.setAdapter(rec1);



    }
    //课程列表
    @Override
    public void showKe(OneKeBean oneKeBean) {
        List<OneKeBean.DataBean.CourseBean> course = oneKeBean.getData().getCourse();
        sJing.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        Study_rec_ke rec2 =new Study_rec_ke(getActivity(),course);
        sJing.addItemDecoration(new RecyclerViewDivider(getActivity(),LinearLayoutManager.VERTICAL,10, Color.parseColor("#c2b8b8")));
        sJing.setAdapter(rec2);
        rec2.setOnItemClickListener(new Study_rec_ke.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent =new Intent(getActivity(),Xiang_KActivity.class);
                intent.putExtra("position",position);
                startActivityForResult(intent,30);
            }
        });
    }

    //获取精选专辑
    @Override
    public void showJing(OneJingBean oneJingBean) {
        List<OneJingBean.DataBean.TopicBean> topic = oneJingBean.getData().getTopic();
        sZhuan.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        Study_rec_jing rec3 =new Study_rec_jing(getActivity(),topic);
        Log.i("rec3",topic.get(0).getTitle());
        sZhuan.addItemDecoration(new RecyclerViewDivider(getActivity(),LinearLayoutManager.VERTICAL,10, Color.BLACK));
        sZhuan.setAdapter(rec3);
         rec3.setOnItemClickListener(new Study_rec_jing.OnItemClickListener() {
             @Override
             public void onItemClick(View view, int position) {
                 Intent intent =new Intent(getActivity(),XiangActivity.class);
                 intent.putExtra("position",position);
                 startActivityForResult(intent,20);
             }
         });
    }
}
