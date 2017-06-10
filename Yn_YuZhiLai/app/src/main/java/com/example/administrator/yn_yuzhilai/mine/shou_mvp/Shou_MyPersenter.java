package com.example.administrator.yn_yuzhilai.mine.shou_mvp;

import android.content.Context;

import com.example.administrator.yn_yuzhilai.bean.CallBean;
import com.example.administrator.yn_yuzhilai.bean.ShouLieBean;
import com.example.administrator.yn_yuzhilai.bean.ZhuBean;

/**
 * 作者：仝晓雅 on 2017/6/7 11:05
 * 类的注释：
 */

public class Shou_MyPersenter implements Shou_Persenter {
    Shou_View shou_view;
    Shou_Model shou_model;
    Context context;

    public Shou_MyPersenter(Context context,Shou_View shou_view) {
        this.shou_view = shou_view;
        this.context=context;
        shou_model =new Shou_MyModel();
    }

    @Override
    public void showlie() {
        shou_model.getShowLie(context, new Shou_Model.OnShowLie() {
            @Override
            public void showLie(ShouLieBean shouLieBean) {
                shou_view.showShow(shouLieBean);

            }

            @Override
            public void showCall(CallBean callBean) {

                shou_view.showCall(callBean);
            }

           /* @Override
            public void showZhu(ZhuBean zhuBean) {
                shou_view.showLog(zhuBean);
            }*/
        });

    }
}
