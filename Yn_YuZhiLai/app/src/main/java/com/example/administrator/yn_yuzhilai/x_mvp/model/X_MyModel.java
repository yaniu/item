package com.example.administrator.yn_yuzhilai.x_mvp.model;

import android.content.Context;
import android.util.Log;

import com.example.administrator.yn_yuzhilai.bean.FenBean;
import com.example.administrator.yn_yuzhilai.bean.JingBean;
import com.example.administrator.yn_yuzhilai.bean.KeBean;
import com.example.administrator.yn_yuzhilai.tools.MyServer;
import com.example.administrator.yn_yuzhilai.tools.SharedpreferenceUtile;
import com.example.administrator.yn_yuzhilai.tools.Utlues;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DefaultSubscriber;

/**
 * 作者：仝晓雅 on 2017/6/5 16:39
 * 类的注释：
 */

public class X_MyModel implements X_Model {
    @Override
    public void getKeXiang(Context context, int position, final OngetKe ongetKe) {
        getKe(context,position,ongetKe);
        getJing(context,position,ongetKe);
        getFen(context,position,ongetKe);
    }

    private void getFen(Context context, int position, final OngetKe ongetKe) {
        StringBuffer sb =new StringBuffer();
        sb.append(SharedpreferenceUtile.getInstance().getKEY())
                .append(SharedpreferenceUtile.getInstance().getID())
                .append(Utlues.APP_dev_id(context))
                .append(Utlues.APP_ver_code(context))
                .append(Utlues.APP_tick())
                .append(SharedpreferenceUtile.getInstance().getBaseSession())
                .append(position);
        Log.i("f1_1",SharedpreferenceUtile.getInstance().getKEY());
        Log.i("f1_2",SharedpreferenceUtile.getInstance().getID());
        Log.i("f1_3",Utlues.APP_dev_id(context));
        Log.i("f1_4",Utlues.APP_ver_code(context)+"");
        Log.i("f1_5",Utlues.APP_tick());
        Log.i("f1_6",SharedpreferenceUtile.getInstance().getBaseSession());
        Log.i("f1_7",position+"");


        String string = sb.toString();
        String sing = Utlues.APP_md5(string);
        String sings = sing.toUpperCase();
        MyServer server = Utlues.getMyServer(SharedpreferenceUtile.getInstance().getBase());
        Flowable<FenBean> shou = server.getFen(SharedpreferenceUtile.getInstance().getID(), Utlues.APP_dev_id(context), Utlues.APP_ver_code(context), Utlues.APP_tick(), SharedpreferenceUtile.getInstance().getBaseSession(), position, sings);
        shou.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DefaultSubscriber<FenBean>() {
                    @Override
                    public void onNext(FenBean fenBean) {
                        ongetKe.getFen(fenBean);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    private void getJing(Context context, int position, final OngetKe ongetKe) {
        StringBuffer sb =new StringBuffer();
        sb.append(SharedpreferenceUtile.getInstance().getKEY())
                .append(SharedpreferenceUtile.getInstance().getID())
                .append(Utlues.APP_dev_id(context))
                .append(Utlues.APP_ver_code(context))
                .append(Utlues.APP_tick())
                .append(position);

        String sign = Utlues.APP_md5(sb.toString()).toUpperCase();
        MyServer server = Utlues.getMyServer(SharedpreferenceUtile.getInstance().getBase());
        Flowable<JingBean> keList_xiang = server.getJingList_xiang(SharedpreferenceUtile.getInstance().getID(), Utlues.APP_dev_id(context), Utlues.APP_ver_code(context), Utlues.APP_tick(), position, sign);
        keList_xiang.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DefaultSubscriber<JingBean>() {
                    @Override
                    public void onNext(JingBean jingBean) {

                        ongetKe.getJing(jingBean);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void getKe(Context context, int position, final OngetKe ongetKe) {
        StringBuffer sb =new StringBuffer();
        sb.append(SharedpreferenceUtile.getInstance().getKEY())
                .append(SharedpreferenceUtile.getInstance().getID())
                .append(Utlues.APP_dev_id(context))
                .append(Utlues.APP_ver_code(context))
                .append(Utlues.APP_tick())
                .append(position);

        String sign = Utlues.APP_md5(sb.toString()).toUpperCase();
        MyServer server = Utlues.getMyServer(SharedpreferenceUtile.getInstance().getBase());
        Flowable<KeBean> keList_xiang = server.getKeList_xiang(SharedpreferenceUtile.getInstance().getID(), Utlues.APP_dev_id(context), Utlues.APP_ver_code(context), Utlues.APP_tick(), position, sign);
        keList_xiang.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DefaultSubscriber<KeBean>() {
                    @Override
                    public void onNext(KeBean keBean) {
                        ongetKe.getKe(keBean);
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
