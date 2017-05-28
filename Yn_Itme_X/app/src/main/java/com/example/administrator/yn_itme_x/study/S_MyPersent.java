package com.example.administrator.yn_itme_x.study;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.administrator.yn_itme_x.bean.OneJingBean;
import com.example.administrator.yn_itme_x.bean.OneKeBean;
import com.example.administrator.yn_itme_x.bean.OneMianBean;
import com.example.administrator.yn_itme_x.utilus.OnePicBean;
import com.example.administrator.yn_itme_x.utilus.Utlues;

import java.util.ArrayList;

/**
 * 作者：仝晓雅 on 2017/5/25 20:00
 * 类的注释：
 */

public class S_MyPersent implements S_persent{
    S_view s_view;
    S_model s_model;
    Context context ;
    SharedPreferences sharedPreferences;

    //初始化View 与 Model
    public S_MyPersent(Context context,S_view s_view) {
       this.context =context;
        this.s_view = s_view;
        this.sharedPreferences =context.getSharedPreferences("con",Context.MODE_PRIVATE);
        s_model =new S_MyModel();
    }
    //对外提供一个方法进行获取轮播图
    @Override
    public void showListBannerToView() {
        s_model.getShowBanner(context, sharedPreferences, Utlues.getAppKey(sharedPreferences),Utlues.APP_dev_id(context), Utlues.APP_ver_code(context), new S_model.OnDataLineners() {
            @Override
            public void getData(OnePicBean onePicBean) {
                s_view.showBanner(onePicBean);
            }
        });
    }
    //对外提供一个方法进行获取免费列表
    @Override
    public void showListMianToView() {
        s_model.getShowMian(context, sharedPreferences, new S_model.OnMianLineners() {
            @Override
            public void getDataMian(OneMianBean mianBeen) {
               s_view.showMina(mianBeen);
            }
        });

    }
    //对外提供一个方法进行获取精选课程列表
    public  void showListKeToView(){
        s_model.getShowKe(context, sharedPreferences, new S_model.OnKeLineners() {
            @Override
            public void getDataKe(OneKeBean oneKeBean) {
                s_view.showKe(oneKeBean);
            }
        });
    }
    //对外提供一个方法进行获取精选专辑列表
    public  void showListJingToView(){
      s_model.getShowJ(context, sharedPreferences, new S_model.OniJingLineners() {
          @Override
          public void getDataJing(OneJingBean OneJingBean) {
              s_view.showJing(OneJingBean);
          }
      });
    }



}
