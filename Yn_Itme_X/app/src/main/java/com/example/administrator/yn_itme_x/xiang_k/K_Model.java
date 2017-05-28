package com.example.administrator.yn_itme_x.xiang_k;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.administrator.yn_itme_x.bean.KeBean;

/**
 * 作者：仝晓雅 on 2017/5/26 16:40
 * 类的注释：详情界面(Model接口)
 */

public interface K_Model {
    //详情专辑界面
    void getXiangKeData(Context context, SharedPreferences sh, int position, XiangKe xiangKe);
    interface XiangKe{
        void getxiangzhuan(KeBean keBean);
    }
}
