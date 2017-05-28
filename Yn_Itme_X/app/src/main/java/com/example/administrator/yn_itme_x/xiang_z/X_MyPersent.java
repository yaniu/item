package com.example.administrator.yn_itme_x.xiang_z;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.administrator.yn_itme_x.bean.JingBean;

/**
 * 作者：仝晓雅 on 2017/5/26 16:40
 * 类的注释：详情界面（Persent实现类）
 */

public class X_MyPersent implements X_Persent{
    X_View x_view;
    X_Model x_model;
    Context context;
    SharedPreferences sharedPreferences;

    public X_MyPersent(Context context,X_View x_view) {
        this.x_view = x_view;
        x_model=new X_MyModel();
        this.context =context;
        sharedPreferences =context.getSharedPreferences("con",Context.MODE_PRIVATE);
    }

    @Override
    public void showXiangZhuanToView(int position) {
        x_model.getXiangZhuanData(context, sharedPreferences, position, new X_Model.XiangZhuan() {
            @Override
            public void getxiangzhuan(JingBean jingBean) {
                x_view.show(jingBean);
            }
        });
    }
}
