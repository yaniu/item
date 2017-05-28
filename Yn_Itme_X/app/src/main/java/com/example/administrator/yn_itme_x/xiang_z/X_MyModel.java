package com.example.administrator.yn_itme_x.xiang_z;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.administrator.yn_itme_x.bean.JingBean;
import com.example.administrator.yn_itme_x.utilus.Api;
import com.example.administrator.yn_itme_x.utilus.MyServer;
import com.example.administrator.yn_itme_x.utilus.Utlues;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DefaultSubscriber;

/**
 * 作者：仝晓雅 on 2017/5/26 16:40
 * 类的注释：详情界面（Model实现类）
 */

public class X_MyModel implements X_Model{



    @Override
    public void getXiangZhuanData(Context context, SharedPreferences sh, int position, final XiangZhuan xiangZhuan) {
        StringBuffer sb =new StringBuffer();
        sb.append(Utlues.getPrivateKey(sh))
                .append(Utlues.getAppKey(sh))
                .append(Utlues.APP_dev_id(context))
                .append(Utlues.APP_ver_code(context))
                .append(Utlues.APP_tick())
                .append(position);
        String sign = Utlues.APP_md5(sb.toString()).toUpperCase();
        MyServer server = Utlues.getMyServer(Api.BASE_URL3);
        Flowable<JingBean> xiang = server.getJingList_xiang(Utlues.getAppKey(sh), Utlues.APP_dev_id(context), Utlues.APP_ver_code(context), Utlues.APP_tick(), position, sign);
        xiang.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DefaultSubscriber<JingBean>() {
                    @Override
                    public void onNext(JingBean jingBean) {
                        xiangZhuan.getxiangzhuan(jingBean);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }
}
