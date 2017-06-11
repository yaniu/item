package com.example.administrator.yn_itme_x.xiang_k;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.administrator.yn_itme_x.bean.KeBean;

/**
 * 作者：仝晓雅 on 2017/5/26 16:40
 * 类的注释：详情界面（Persent实现类）
 */

public class K_MyPersent implements K_Persent {
    K_View x_view;
    K_Model x_model;
    Context context;
    SharedPreferences sharedPreferences;

    public K_MyPersent(Context context, K_View x_view) {
        this.x_view = x_view;
        x_model=new K_MyModel();
        this.context =context;
        sharedPreferences =context.getSharedPreferences("con",Context.MODE_PRIVATE);
    }

    @Override
    public void showXiangKeToView(int position) {
        x_model.getXiangKeData(context, sharedPreferences, position, new K_Model.XiangKe() {
            @Override
            public void getxiangzhuan(KeBean keBean) {
                x_view.show(keBean);

            }
        });
    }
}
