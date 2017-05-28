package com.example.administrator.yn_itme_x.xiang_z;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.administrator.yn_itme_x.bean.JingBean;

/**
 * 作者：仝晓雅 on 2017/5/26 16:40
 * 类的注释：详情界面(Model接口)
 */

public interface X_Model {
    //详情专辑界面
    void getXiangZhuanData(Context context, SharedPreferences sh,int position,XiangZhuan xiangZhuan);
    interface XiangZhuan{
        void getxiangzhuan(JingBean jingBean);
    }
}
