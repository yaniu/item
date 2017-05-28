package com.example.administrator.yn_itme_x.study;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.administrator.yn_itme_x.bean.OneJingBean;
import com.example.administrator.yn_itme_x.bean.OneKeBean;
import com.example.administrator.yn_itme_x.bean.OneMianBean;
import com.example.administrator.yn_itme_x.utilus.Api;
import com.example.administrator.yn_itme_x.utilus.MyServer;
import com.example.administrator.yn_itme_x.utilus.OnePicBean;
import com.example.administrator.yn_itme_x.utilus.Utlues;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DefaultSubscriber;

/**
 * 作者：仝晓雅 on 2017/5/25 16:46
 * 类的注释：
 */

public class S_MyModel implements S_model {

    /**
     * 首页轮播图
     * @param app_id
     * @param dev_id
     * @param code
     *
     */
    @Override
    public void getShowBanner(Context context, SharedPreferences sh, String app_id, String dev_id, int code, final OnDataLineners onDataLineners) {
        StringBuffer sb =new StringBuffer();
        sb.append(Utlues.getPrivateKey(sh))
                .append(Utlues.getAppKey(sh))
                .append(Utlues.APP_dev_id(context))
                .append(Utlues.APP_ver_code(context))
                .append(Utlues.APP_tick());
        String sing = Utlues.APP_md5(sb.toString()).toUpperCase();
        Log.i("private",Utlues.getPrivateKey(sh));
        Log.i("key",Utlues.getAppKey(sh));
        Log.i("id",Utlues.APP_dev_id(context));
        Log.i("code",Utlues.APP_ver_code(context)+"");
        Log.i("tick",Utlues.APP_tick());

        MyServer server = Utlues.getMyServer(Api.BASE_URL3);
        Flowable<OnePicBean> banner = server.getListBanner(app_id, dev_id, code, Utlues.APP_tick(), sing);
        banner.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DefaultSubscriber<OnePicBean>() {
                    @Override
                    public void onNext(OnePicBean onePicBean) {
                        Log.i("one",onePicBean.getRet()+"");
                        onDataLineners.getData(onePicBean);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    /**
     * 免费试听列表

     */
    @Override
    public void getShowMian(Context context, SharedPreferences sh, final OnMianLineners onMianLineners) {
        StringBuffer sb =new StringBuffer();
        sb.append(Utlues.getPrivateKey(sh))
                .append(Utlues.getAppKey(sh))
                .append(Utlues.APP_dev_id(context))
                .append(Utlues.APP_ver_code(context))
                .append(Utlues.APP_tick())
                .append(10)
                .append(0);
        String sign = Utlues.APP_md5(sb.toString()).toUpperCase();
        MyServer server = Utlues.getMyServer(Api.BASE_URL3);
        Flowable<OneMianBean> mianList = server.getMianList(Utlues.getAppKey(sh), Utlues.APP_dev_id(context), Utlues.APP_ver_code(context), Utlues.APP_tick(), 10, 0, sign);
        mianList.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DefaultSubscriber<OneMianBean>() {
                    @Override
                    public void onNext(OneMianBean oneMianBean) {
                        Log.i("mian",oneMianBean.getRet()+"");
                      onMianLineners.getDataMian(oneMianBean);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }
    /**
     * 精选课程列表列表

     */
    @Override
    public void getShowKe(Context context, SharedPreferences sh, final OnKeLineners onKeLineners) {
        StringBuffer sb =new StringBuffer();
        sb.append(Utlues.getPrivateKey(sh))
                .append(Utlues.getAppKey(sh))
                .append(Utlues.APP_dev_id(context))
                .append(Utlues.APP_ver_code(context))
                .append(Utlues.APP_tick())
                .append(10)
                .append(0);
        String sign = Utlues.APP_md5(sb.toString()).toUpperCase();
        MyServer server = Utlues.getMyServer(Api.BASE_URL3);
        Flowable<OneKeBean> keList = server.getKeList(Utlues.getAppKey(sh), Utlues.APP_dev_id(context), Utlues.APP_ver_code(context), Utlues.APP_tick(), 10, 0, sign);
        keList.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DefaultSubscriber<OneKeBean>() {
                    @Override
                    public void onNext(OneKeBean oneKeBean) {
                        onKeLineners.getDataKe(oneKeBean);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getShowJ(Context context, SharedPreferences sh, final OniJingLineners oniJingLineners) {
        StringBuffer sb =new StringBuffer();
        sb.append(Utlues.getPrivateKey(sh))
                .append(Utlues.getAppKey(sh))
                .append(Utlues.APP_dev_id(context))
                .append(Utlues.APP_ver_code(context))
                .append(Utlues.APP_tick())
                .append(10)
                .append(0);
        String sign = Utlues.APP_md5(sb.toString()).toUpperCase();
        MyServer server = Utlues.getMyServer(Api.BASE_URL3);
        Flowable<OneJingBean> keList = server.getJingList(Utlues.getAppKey(sh), Utlues.APP_dev_id(context), Utlues.APP_ver_code(context), Utlues.APP_tick(), 10, 0, sign);
        keList.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DefaultSubscriber<OneJingBean>() {
                    @Override
                    public void onNext(OneJingBean oneJingBean) {
                        oniJingLineners.getDataJing(oneJingBean);
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
