package com.example.administrator.yn_yuzhilai.mine.shou_mvp;

import android.content.Context;

import com.example.administrator.yn_yuzhilai.bean.CallBean;
import com.example.administrator.yn_yuzhilai.bean.FenBean;
import com.example.administrator.yn_yuzhilai.bean.ShouLieBean;
import com.example.administrator.yn_yuzhilai.bean.ZhuBean;

/**
 * 作者：仝晓雅 on 2017/6/7 11:04
 * 类的注释：
 */

public interface Shou_Model {

    void getShowLie(Context context,OnShowLie onShowLie);
    interface  OnShowLie{
        void showLie(ShouLieBean shouLieBean);
        void showCall(CallBean callBean);
       // void showZhu(ZhuBean zhuBean);

    }
}
