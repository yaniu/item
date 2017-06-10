package com.example.administrator.yn_yuzhilai.s_mvp.model;

import android.content.Context;
import android.util.Log;

import com.example.administrator.yn_yuzhilai.bean.CateGroyBean;
import com.example.administrator.yn_yuzhilai.bean.OneJingBean;
import com.example.administrator.yn_yuzhilai.bean.OneKeBean;
import com.example.administrator.yn_yuzhilai.bean.OneMianBean;
import com.example.administrator.yn_yuzhilai.bean.OnePicBean;
import com.example.administrator.yn_yuzhilai.tools.MyServer;
import com.example.administrator.yn_yuzhilai.tools.SharedpreferenceUtile;
import com.example.administrator.yn_yuzhilai.tools.Utlues;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DefaultSubscriber;

/**
 * 作者：仝晓雅 on 2017/6/2 19:52
 * 类的注释：
 */

public class MyModels implements MyModel {
    @Override
    public void getData(Context context, final OnData onData) {
        //轮播图
       getBanner(context,onData);
        //免费课程
        getMian(context,onData);
        //课程列表
        getKe(context,onData);
        //专辑列表
        getZhuan(context,onData);
        //课程分类Tab
        getCateTab(context,onData);

    }

    private void getCateTab(Context context, final OnData onData) {
        MyServer server = Utlues.getMyServer(SharedpreferenceUtile.getInstance().getBase());
        String sing = Utlues.getBanner(SharedpreferenceUtile.getInstance().getKEY(),
                SharedpreferenceUtile.getInstance().getID(),
                Utlues.APP_dev_id(context),
                Utlues.APP_ver_code(context),
                Utlues.APP_tick()
        );
        Flowable<CateGroyBean> banner = server.getCate(SharedpreferenceUtile.getInstance().getID(),
                Utlues.APP_dev_id(context),
                Utlues.APP_ver_code(context),
                Utlues.APP_tick(), sing);
        banner.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DefaultSubscriber<CateGroyBean>() {
                    @Override
                    public void onNext(CateGroyBean cate) {

                       onData.CateTab(cate);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    private void getZhuan(Context context, final OnData onData) {
        StringBuffer sb =new StringBuffer();
        sb.append(SharedpreferenceUtile.getInstance().getKEY())
                .append(SharedpreferenceUtile.getInstance().getID())
                .append(Utlues.APP_dev_id(context))
                .append(Utlues.APP_ver_code(context))
                .append(Utlues.APP_tick())
                .append(10)
                .append(0);
        String sign = Utlues.APP_md5(sb.toString()).toUpperCase();
        MyServer server = Utlues.getMyServer(SharedpreferenceUtile.getInstance().getBase());
        Flowable<OneJingBean> mianList = server.getJingList(SharedpreferenceUtile.getInstance().getID(), Utlues.APP_dev_id(context), Utlues.APP_ver_code(context), Utlues.APP_tick(), 10, 0, sign);
        mianList.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DefaultSubscriber<OneJingBean>() {
                    @Override
                    public void onNext(OneJingBean oneJangBean)
                    {
                        onData.Zhuan(oneJangBean);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void getKe(Context context, final OnData onData) {
        StringBuffer sb =new StringBuffer();
        sb.append(SharedpreferenceUtile.getInstance().getKEY())
                .append(SharedpreferenceUtile.getInstance().getID())
                .append(Utlues.APP_dev_id(context))
                .append(Utlues.APP_ver_code(context))
                .append(Utlues.APP_tick())
                .append(10)
                .append(0);
        String sign = Utlues.APP_md5(sb.toString()).toUpperCase();
        MyServer server = Utlues.getMyServer(SharedpreferenceUtile.getInstance().getBase());
        Flowable<OneKeBean> mianList = server.getKeList(SharedpreferenceUtile.getInstance().getID(), Utlues.APP_dev_id(context), Utlues.APP_ver_code(context), Utlues.APP_tick(), 10, 0, sign);
        mianList.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DefaultSubscriber<OneKeBean>() {
                    @Override
                    public void onNext(OneKeBean OneKeBean)
                    {
                       onData.Ke(OneKeBean);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void getMian(Context context, final OnData onData) {
        StringBuffer sb =new StringBuffer();
        sb.append(SharedpreferenceUtile.getInstance().getKEY())
                .append(SharedpreferenceUtile.getInstance().getID())
                .append(Utlues.APP_dev_id(context))
                .append(Utlues.APP_ver_code(context))
                .append(Utlues.APP_tick())
                .append(10)
                .append(0);
        String sign = Utlues.APP_md5(sb.toString()).toUpperCase();
        MyServer server = Utlues.getMyServer(SharedpreferenceUtile.getInstance().getBase());
        Flowable<OneMianBean> mianList = server.getMianList(SharedpreferenceUtile.getInstance().getID(), Utlues.APP_dev_id(context), Utlues.APP_ver_code(context), Utlues.APP_tick(), 10, 0, sign);
        mianList.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DefaultSubscriber<OneMianBean>() {
                    @Override
                    public void onNext(OneMianBean oneMianBean) {
                       onData.main(oneMianBean);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    private void getBanner(Context context,final OnData onData) {
        MyServer server = Utlues.getMyServer(SharedpreferenceUtile.getInstance().getBase());
        String sing = Utlues.getBanner(SharedpreferenceUtile.getInstance().getKEY(),
                SharedpreferenceUtile.getInstance().getID(),
                Utlues.APP_dev_id(context),
                Utlues.APP_ver_code(context),
                Utlues.APP_tick()
        );
        Flowable<OnePicBean> banner = server.getListBanner(SharedpreferenceUtile.getInstance().getID(),
                Utlues.APP_dev_id(context),
                Utlues.APP_ver_code(context),
                Utlues.APP_tick(), sing);
        banner.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DefaultSubscriber<OnePicBean>() {
                    @Override
                    public void onNext(OnePicBean onePicBean) {

                        onData.data(onePicBean);
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
