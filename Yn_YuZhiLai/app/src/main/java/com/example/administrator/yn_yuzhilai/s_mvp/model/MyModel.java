package com.example.administrator.yn_yuzhilai.s_mvp.model;

import android.content.Context;

import com.example.administrator.yn_yuzhilai.bean.CateGroyBean;
import com.example.administrator.yn_yuzhilai.bean.OneJingBean;
import com.example.administrator.yn_yuzhilai.bean.OneKeBean;
import com.example.administrator.yn_yuzhilai.bean.OneMianBean;
import com.example.administrator.yn_yuzhilai.bean.OnePicBean;

/**
 * 作者：仝晓雅 on 2017/6/2 19:49
 * 类的注释：
 */

public interface MyModel {
    void getData(Context context,OnData onData);
    interface OnData{
        //获取轮播图
        void data(OnePicBean onePicBean);
        //获取免费课程
        void main(OneMianBean oneMianBean);
        //获取课程列表
        void Ke(OneKeBean oneKeBean);
        //获取专辑列表
        void Zhuan(OneJingBean oneJingBean);
        //获取专辑列表
        void CateTab(CateGroyBean cateGroyBean);

    }


}
