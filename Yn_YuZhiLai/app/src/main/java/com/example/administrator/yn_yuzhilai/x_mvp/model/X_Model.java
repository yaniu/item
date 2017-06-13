package com.example.administrator.yn_yuzhilai.x_mvp.model;

import android.content.Context;

import com.example.administrator.yn_yuzhilai.bean.FenBean;
import com.example.administrator.yn_yuzhilai.bean.JingBean;
import com.example.administrator.yn_yuzhilai.bean.KeBean;

/**
 * 作者：仝晓雅 on 2017/6/5 16:37
 * 类的注释：
 */

public interface X_Model {
    void getKeXiang(Context context,int position,OngetKe ongetKe);
    interface  OngetKe{
        void getKe(KeBean keBean);
        void getJing(JingBean jingBean);
      //  void getFen(FenBean fenBean);
    }
}
