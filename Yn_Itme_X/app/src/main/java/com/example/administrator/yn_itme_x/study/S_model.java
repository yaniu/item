package com.example.administrator.yn_itme_x.study;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.administrator.yn_itme_x.bean.OneJingBean;
import com.example.administrator.yn_itme_x.bean.OneKeBean;
import com.example.administrator.yn_itme_x.bean.OneMianBean;
import com.example.administrator.yn_itme_x.utilus.OnePicBean;

import java.util.ArrayList;

/**
 * 作者：仝晓雅 on 2017/5/23 20:25
 * 类的注释：
 */

public interface S_model {

    //首页轮播图
    void getShowBanner(Context context, SharedPreferences sh, String app_id, String  dev_id, int code,OnDataLineners onDataLineners);
    //声明接口
    interface  OnDataLineners{
        void getData(OnePicBean onePicBean);
    }
    //试听列表
    void getShowMian(Context context,SharedPreferences sh,OnMianLineners onMianLineners);
    interface  OnMianLineners{
        void getDataMian(OneMianBean mianBeen );
    }
    //精选课程
    void getShowKe(Context context,SharedPreferences sh,OnKeLineners onKeLineners);
    interface  OnKeLineners{
        void  getDataKe(OneKeBean oneKeBean);
    }
    //精选专辑
    void getShowJ(Context context,SharedPreferences sh,OniJingLineners oniJingLineners);
    interface  OniJingLineners{
        void  getDataJing(OneJingBean OneJingBean);
    }

}
