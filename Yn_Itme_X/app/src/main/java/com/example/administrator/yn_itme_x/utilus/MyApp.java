package com.example.administrator.yn_itme_x.utilus;

import android.app.Application;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.administrator.yn_itme_x.bean.FirstHandBean;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DefaultSubscriber;


/**
 * 作者：仝晓雅 on 2017/5/25 16:02
 * 类的注释：
 */

public class MyApp extends Application {

    public SharedPreferences sharedPreferences;
    private SharedPreferences.Editor edit;

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化sharedPreferences
        sharedPreferences = getSharedPreferences("con",MODE_PRIVATE);
        edit = sharedPreferences.edit();
        //获得首次安装的标识


        if(sharedPreferences.getBoolean(Api.ISFIRSTINSTALL,false)){
            return;
        }

        getData(Utlues.APP_tpye,Utlues.APP_dev_id(this),Utlues.APP_ver_code(this),Utlues.APP_tick());
    }
    /**
     *首次握手
     * @param type app类型
     * @param id 设备ID
     * @param code 版本号
     * @param tick 时间戳
     */

    private void getData(String type,String id,int code,String tick) {
       //生成签名
        StringBuffer sb =new StringBuffer();
        sb.append(Api.POST_YAO)
          .append(type)
          .append(id)
          .append(code)
          .append(tick);
        Log.i("sb",sb.toString());
        //MD5加密
        String md5 = Utlues.APP_md5(sb.toString());
        //转换成大写
        String sign = md5.toUpperCase();
        Log.i("xxx",sign);
        //获得调用接口
        MyServer server = Utlues.getMyServer(Api.POST_URL);
        Log.i("server",server.toString());
        Flowable<FirstHandBean> firstHand = server.getFirstHand(type, id, code, tick, sign);
        firstHand.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DefaultSubscriber<FirstHandBean>() {
                    @Override
                    public void onNext(FirstHandBean firstHandBean) {
                        Log.i("xxxx","assasaassa");
                        Log.i("xxxx",firstHandBean.toString());
                        //拿到AppKey和Appid
                        String key = firstHandBean.getData().getPrivate_key();
                        String app_key = firstHandBean.getData().getApp_id();
                        Log.i("id",key+"->id:"+app_key);

                        //将获得的数据保存起来
                        edit.putString(Api.PRIVATE_KEY,key);
                        edit.putString(Api.APP_ID,app_key);
                        //记录请求
                        edit.putBoolean(Api.ISFIRSTINSTALL,true);
                        //提交
                        edit.commit();
                    }

                    @Override
                    public void onError(Throwable t) {
                       Log.i("xxxxe",t.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
