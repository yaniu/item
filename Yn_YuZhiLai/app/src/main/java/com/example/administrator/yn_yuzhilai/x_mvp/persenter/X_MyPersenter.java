package com.example.administrator.yn_yuzhilai.x_mvp.persenter;

import android.content.Context;

import com.example.administrator.yn_yuzhilai.bean.FenBean;
import com.example.administrator.yn_yuzhilai.bean.JingBean;
import com.example.administrator.yn_yuzhilai.bean.KeBean;
import com.example.administrator.yn_yuzhilai.x_mvp.model.X_Model;
import com.example.administrator.yn_yuzhilai.x_mvp.model.X_MyModel;
import com.example.administrator.yn_yuzhilai.x_mvp.view.X_View;

/**
 * 作者：仝晓雅 on 2017/6/5 16:45
 * 类的注释：
 */

public class X_MyPersenter implements X_Persenter {
    X_View x_view;
    X_Model x_model;
    Context context;

    public X_MyPersenter(Context context,X_View x_view) {
        this.x_view = x_view;
        x_model =new X_MyModel();
        this.context=context;


    }

    @Override
    public void getXiang(int position) {
        x_model.getKeXiang(context, position, new X_Model.OngetKe() {
            @Override
            public void getKe(KeBean keBean) {
                x_view.showKeXiang(keBean);
            }

            @Override
            public void getJing(JingBean jingBean) {
                x_view.showZhuanXiang(jingBean);
            }

            @Override
            public void getFen(FenBean fenBean) {
                x_view.showFen(fenBean);
            }
        });
    }
}
