package com.example.administrator.yn_yuzhilai.mine.shou_mvp;

import android.content.Context;
import android.util.Log;

import com.example.administrator.yn_yuzhilai.bean.CallBean;
import com.example.administrator.yn_yuzhilai.bean.FenBean;
import com.example.administrator.yn_yuzhilai.bean.ShouBean;
import com.example.administrator.yn_yuzhilai.bean.ShouLieBean;
import com.example.administrator.yn_yuzhilai.tools.MyServer;
import com.example.administrator.yn_yuzhilai.tools.SharedpreferenceUtile;
import com.example.administrator.yn_yuzhilai.tools.Utlues;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DefaultSubscriber;

/**
 * 作者：仝晓雅 on 2017/6/7 11:04
 * 类的注释：
 */

public class Shou_MyModel implements Shou_Model {

   /* private void getZhu(Context context, final OnShowLie onShowLie) {
        StringBuffer sb =new StringBuffer();
        sb.append(SharedpreferenceUtile.getInstance().getKEY())
                .append(SharedpreferenceUtile.getInstance().getID())
                .append(Utlues.APP_dev_id(context))
                .append(Utlues.APP_ver_code(context))
                .append(Utlues.APP_tick())
                .append(SharedpreferenceUtile.getInstance().getBaseSession());
        String string = sb.toString();
        String sing = Utlues.APP_md5(string);
        String aCase = sing.toUpperCase();
        MyServer server = Utlues.getMyServer(SharedpreferenceUtile.getInstance().getBase());
        Flowable<ZhuBean> shouLie = server.getZhu(SharedpreferenceUtile.getInstance().getID(), Utlues.APP_dev_id(context), Utlues.APP_ver_code(context), Utlues.APP_tick(), SharedpreferenceUtile.getInstance().getBaseSession(),aCase);
        shouLie.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DefaultSubscriber<ZhuBean>() {
                    @Override
                    public void onNext(ZhuBean zhu) {
                        onShowLie.showZhu(zhu);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }*/

    private void getCall(Context context, final OnShowLie onShowLie) {
        StringBuffer sb =new StringBuffer();
        sb.append(SharedpreferenceUtile.getInstance().getKEY())
                .append(SharedpreferenceUtile.getInstance().getID())
                .append(Utlues.APP_dev_id(context))
                .append(Utlues.APP_ver_code(context))
                .append(Utlues.APP_tick())
                .append(SharedpreferenceUtile.getInstance().getBaseSession());
        String string = sb.toString();
        String sing = Utlues.APP_md5(string);
        String aCase = sing.toUpperCase();
        MyServer server = Utlues.getMyServer(SharedpreferenceUtile.getInstance().getBase());
        Flowable<CallBean> shouLie = server.getKeLie(SharedpreferenceUtile.getInstance().getID(), Utlues.APP_dev_id(context), Utlues.APP_ver_code(context), Utlues.APP_tick(), SharedpreferenceUtile.getInstance().getBaseSession(),aCase);
        shouLie.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DefaultSubscriber<CallBean>() {
                    @Override
                    public void onNext(CallBean call) {
                        onShowLie.showCall(call);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    private void getShow(Context context, final OnShowLie onShowLie) {
        StringBuffer sb =new StringBuffer();
        sb.append(SharedpreferenceUtile.getInstance().getKEY())
                .append(SharedpreferenceUtile.getInstance().getID())
                .append(Utlues.APP_dev_id(context))
                .append(Utlues.APP_ver_code(context))
                .append(Utlues.APP_tick())
                .append(SharedpreferenceUtile.getInstance().getBaseSession());
        String string = sb.toString();
        String sing = Utlues.APP_md5(string);
        String aCase = sing.toUpperCase();
        MyServer server = Utlues.getMyServer(SharedpreferenceUtile.getInstance().getBase());
        Flowable<ShouLieBean> shouLie = server.getShouLie(SharedpreferenceUtile.getInstance().getID(), Utlues.APP_dev_id(context), Utlues.APP_ver_code(context), Utlues.APP_tick(), SharedpreferenceUtile.getInstance().getBaseSession(),aCase);
        shouLie.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DefaultSubscriber<ShouLieBean>() {
                    @Override
                    public void onNext(ShouLieBean shouLieBean) {
                        Log.i("s",shouLieBean.getRet()+"");
                        onShowLie.showLie(shouLieBean);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }


   /* @Override
    public void getShowLie(Context context, int object_id, OnShowLie onShowLie) {
        //获取收藏列表
        getShow(context,onShowLie);
        //获取客服电话
        getCall(context,onShowLie);
        //获取注销客户
        // getZhu(context,onShowLie);
        getFen(context,object_id,onShowLie);
    }*/

    @Override
    public void getShowLie(Context context, OnShowLie onShowLie) {
        //获取收藏列表
        getShow(context,onShowLie);
        //获取客服电话
        getCall(context,onShowLie);
        //获取注销客户
        // getZhu(context,onShowLie);
    }
}
