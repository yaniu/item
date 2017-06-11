package com.example.administrator.yn_yuzhilai.x_mvp.view;

import com.example.administrator.yn_yuzhilai.bean.FenBean;
import com.example.administrator.yn_yuzhilai.bean.JingBean;
import com.example.administrator.yn_yuzhilai.bean.KeBean;

/**
 * 作者：仝晓雅 on 2017/6/5 16:36
 * 类的注释：
 */

public interface X_View {

    //课程详情
    void showKeXiang(KeBean keBean);
    //专辑详情
    void showZhuanXiang(JingBean jingBean);

    //分享界面
    void showFen(FenBean fenBean);

}
