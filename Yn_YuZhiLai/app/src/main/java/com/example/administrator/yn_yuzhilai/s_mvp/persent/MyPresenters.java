package com.example.administrator.yn_yuzhilai.s_mvp.persent;

import android.content.Context;
import android.util.Log;

import com.example.administrator.yn_yuzhilai.bean.CateGroyBean;
import com.example.administrator.yn_yuzhilai.bean.OneJingBean;
import com.example.administrator.yn_yuzhilai.bean.OneKeBean;
import com.example.administrator.yn_yuzhilai.bean.OneMianBean;
import com.example.administrator.yn_yuzhilai.bean.OnePicBean;
import com.example.administrator.yn_yuzhilai.s_mvp.model.MyModel;
import com.example.administrator.yn_yuzhilai.s_mvp.model.MyModels;
import com.example.administrator.yn_yuzhilai.s_mvp.view.MyView;

/**
 * 作者：仝晓雅 on 2017/6/2 20:00
 * 类的注释：
 */

public class MyPresenters implements MyPresenter {
    MyView myView;
    MyModel myModel;
    Context context;
    public MyPresenters(Context context,MyView myView) {
        this.myView = myView;
        this.context=context;
        myModel =new MyModels();
    }

    @Override
    public void showDataBeann() {
        myModel.getData(context, new MyModel.OnData() {
            //轮播图
            @Override
            public void data(OnePicBean onePicBean) {
                Log.i("onepic",onePicBean.getRet()+"");
                myView.showBanner(onePicBean);
            }

            //免费课程
            @Override
            public void main(OneMianBean oneMianBean) {
                Log.i("onemian",oneMianBean.getRet()+"");
                myView.showMian(oneMianBean);
            }

            @Override
            public void Ke(OneKeBean oneKeBean) {
                myView.showKe(oneKeBean);
            }

            @Override
            public void Zhuan(OneJingBean oneJingBean) {
                myView.showZhuan(oneJingBean);
            }

            @Override
            public void CateTab(CateGroyBean cateGroyBean) {
                myView.showCateTab(cateGroyBean);
            }
        });

    }


}
