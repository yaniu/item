package com.example.administrator.yn_yuzhilai.s_mvp.view;

import com.example.administrator.yn_yuzhilai.bean.CateGroyBean;
import com.example.administrator.yn_yuzhilai.bean.OneJingBean;
import com.example.administrator.yn_yuzhilai.bean.OneKeBean;
import com.example.administrator.yn_yuzhilai.bean.OneMianBean;
import com.example.administrator.yn_yuzhilai.bean.OnePicBean;

/**
 * 作者：仝晓雅 on 2017/6/2 19:48
 * 类的注释：学习界面
 */

public interface MyView {
    //图片列表
    void showBanner(OnePicBean onePicBean);
    //免费列表
    void showMian(OneMianBean oneMianBean);
    //课程列表
    void showKe(OneKeBean oneKeBean);
    //课程列表
    void showZhuan(OneJingBean oneJingBean);
    //课程分类
    void showCateTab(CateGroyBean cateGroyBean);
}
