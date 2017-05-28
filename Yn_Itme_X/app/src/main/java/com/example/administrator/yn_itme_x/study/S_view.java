package com.example.administrator.yn_itme_x.study;

import com.example.administrator.yn_itme_x.bean.OneJingBean;
import com.example.administrator.yn_itme_x.bean.OneKeBean;
import com.example.administrator.yn_itme_x.bean.OneMianBean;
import com.example.administrator.yn_itme_x.utilus.OnePicBean;

import java.util.ArrayList;

/**
 * 作者：仝晓雅 on 2017/5/23 20:25
 * 类的注释：
 */

public interface S_view {

    //图片列表
    void showBanner(OnePicBean onePicBean);
    //免费课程
    void showMina(OneMianBean mianBeen);
    //精选课程
    void showKe(OneKeBean oneKeBean);
    //精选专辑
    void showJing(OneJingBean oneJingBean);

}
