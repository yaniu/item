package com.example.administrator.yn_yuzhilai.tools;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 作者：仝晓雅 on 2017/5/25 15:09
 * 类的注释：工具类
 */

public class Utlues {

    //获取APP类型
    public  static  String APP_tpye ="ANDROID";
    private static OkHttpClient client;

    //获取设备ID
    public  static  String  APP_dev_id(Context context){
       TelephonyManager manager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        String id = manager.getDeviceId();
       if(id==null||id.trim().length()==0){
          id =String.valueOf(System.currentTimeMillis());
      }
        return  id;
    }

    //获取app版本序号
    public  static int APP_ver_code(Context context){
        int code =-1;
        try {
             code = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;

       } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            Log.i("xxx--app版本号",e.getMessage());
        }
       return code;
    }
    //获取APP名称
    public  static  String APP_name(Context context){
        String name ="";
        try {
             name = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            Log.i("xxx--app名称",name);
        }
        return  name;
    }
    //获取时间戳
    public  static String APP_tick(){
        Date date =new Date();
        long time = date.getTime();
        String of = String.valueOf(time);
        String tick = of.substring(0, 10);
        return  tick;

    }
    //计算MD5算法
    public static String APP_md5(String string) {
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(string.getBytes());
            String result = "";
            for (byte b : bytes) {
                String temp = Integer.toHexString(b & 0xff);
                if (temp.length() == 1) {
                    temp = "0" + temp;
                }
                result += temp;
            }
            return result;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
    //获得Retrofit 的请求接口
    public  static MyServer  getMyServer(String url){
        //初始化日志拦截器
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.i("Banner", "message:" + message);
            }
        });
        //设置日志级别
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //创建OkHttpClient
        client = new OkHttpClient.Builder()
                 .addInterceptor(httpLoggingInterceptor).build();
               Retrofit retrofit =new Retrofit.Builder().client(client).baseUrl(url)
                           .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
        return  retrofit.create(MyServer.class);
    }

   /* *//**
     * 获得首次安装的标识
     * @param preferences
     * @return
     *//*
    public static boolean isFirstInstall(SharedPreferences preferences){
        boolean isFirstInstall = preferences.getBoolean(Api.ISFIRSTINSTALL,false);
        return isFirstInstall;
    }*/

    /**
     * 获得AppKey
     * @param preferences
     * @return
     */
    /*public static String getAppKey(SharedPreferences preferences){
        String appKey = preferences.getString(Api.APP_ID,"");
        return appKey;
    }*/

    /**
     * 获得privateKey
     * @param
     * @return
     */
   /* public static String getPrivateKey(SharedPreferences preferences){
        String privateKey = preferences.getString(Api.PRIVATE_KEY,"");
        return privateKey;
    }*/
    //生成签名
    public static String getSign(String app_tpye, String id, int code, String tick) {
        //生成签名
        StringBuffer sb =new StringBuffer();
        sb.append(Api.POST_YAO)
                .append(app_tpye)
                .append(id)
                .append(code)
                .append(tick);
        Log.i("sb",sb.toString());
        //MD5加密
        String md5 = Utlues.APP_md5(sb.toString());
        //转换成大写
        String sign = md5.toUpperCase();
        return sign;
    }
    //获取导向
    public static String getTwoDao(String key, String id, String dev_id, int code, String tick) {
        //生成签名
        StringBuffer sb =new StringBuffer();
        sb.append(key)
                .append(id)
                .append(dev_id)
                .append(code)
                .append(tick);

        //MD5加密
        String md5 = Utlues.APP_md5(sb.toString());
        //转换成大写
        String sign = md5.toUpperCase();
        Log.i("sb",sign);
        return sign;
    }
    //获取轮播图
    public static String getBanner(String key, String id, String dev_id, int code, String tick) {
        //生成签名
        StringBuffer sb =new StringBuffer();
        sb.append(key)
                .append(id)
                .append(dev_id)
                .append(code)
                .append(tick);

        //MD5加密
        String md5 = Utlues.APP_md5(sb.toString());
        //转换成大写
        String sign = md5.toUpperCase();
        Log.i("sb",sign);
        return sign;
    }


}
