package com.example.administrator.yn_yuzhilai.mine.shou_mvp;

import com.example.administrator.yn_yuzhilai.bean.CallBean;
import com.example.administrator.yn_yuzhilai.bean.ShouLieBean;
import com.example.administrator.yn_yuzhilai.bean.ZhuBean;

/**
 * 作者：仝晓雅 on 2017/6/7 11:03
 * 类的注释：
 */

public interface Shou_View {
//获取收藏列表
    void showShow(ShouLieBean shouLieBean);
//获取客服
    void showCall(CallBean callBean);
 /* //注销账户
    void showLog(ZhuBean zhuBean);*/

}
