package com.example.administrator.yn_itme_x.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.yn_itme_x.R;
import com.example.administrator.yn_itme_x.bean.MaBean;
import com.example.administrator.yn_itme_x.bean.RegBean;

import com.example.administrator.yn_itme_x.utilus.Api;
import com.example.administrator.yn_itme_x.utilus.MyApp;
import com.example.administrator.yn_itme_x.utilus.MyServer;
import com.example.administrator.yn_itme_x.utilus.Utlues;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DefaultSubscriber;

/**
 * 作者：仝晓雅 on 2017/5/27 16:57
 * 类的注释：注册界面
 */

public class RegiesActivity extends Activity {

    @Bind(R.id.reg_phone)
    EditText regPhone;
    @Bind(R.id.reg_ye)
    EditText regYe;
    @Bind(R.id.reg_huo)
    TextView regHuo;
    @Bind(R.id.reg_paw)
    EditText regPaw;
    @Bind(R.id.reg_btn)
    Button regBtn;
    private SharedPreferences.Editor edit;
    private SharedPreferences sh;
    private SharedPreferences con;
    private String pwd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.regist_layout);
        ButterKnife.bind(this);
        sh=getSharedPreferences("log",MODE_PRIVATE);
        edit =sh.edit();


    }

    @OnClick({R.id.reg_phone, R.id.reg_ye, R.id.reg_huo, R.id.reg_paw, R.id.reg_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.reg_phone:
                break;
            case R.id.reg_ye:
                break;
            case R.id.reg_huo:
                String mobile = regPhone.getText().toString().trim();
                con = getSharedPreferences("con",MODE_PRIVATE);
                if(!TextUtils.isEmpty(mobile)&&mobile.length()==11) {
                    String dev_id = Utlues.APP_dev_id(RegiesActivity.this);
                    int ver_code = Utlues.APP_ver_code(RegiesActivity.this);
                    String tick = Utlues.APP_tick();
                    String appkey =Utlues.getAppKey(con);
                    String priveKey =Utlues.getPrivateKey(con);
                    StringBuffer str = new StringBuffer();
                    str.append(priveKey)
                            .append(appkey)
                            .append(dev_id)
                            .append(ver_code)
                            .append(tick)
                            .append(mobile);
               //     Log.i("logins", str + "");

                    //进行加密处理
                    String md5 = Utlues.APP_md5(str.toString());
                    String aCase = md5.toUpperCase();

                    MyServer myServer = Utlues.getMyServer(Api.BASE_URL3);

                    Flowable<RegBean> reg = myServer.getReg(appkey, dev_id, ver_code, tick, mobile, aCase);
                    reg.subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribeWith(new DefaultSubscriber<RegBean>() {
                                @Override
                                public void onNext(RegBean regBean) {
                                    String session = regBean.getData().getSession();
                                    Toast.makeText(RegiesActivity.this, "dsadsadasd", Toast.LENGTH_SHORT).show();
                                    regYe.setText("9998");
                                    edit.putString("reg_session", session);
                                    edit.putBoolean("flag", true);
                                    edit.commit();

                                }

                                @Override
                                public void onError(Throwable t) {

                                }

                                @Override
                                public void onComplete() {

                                }
                            });

                }



                break;
            case R.id.reg_paw:
                break;
            case R.id.reg_btn:
                boolean flag = sh.getBoolean("flag", false);
                if(flag){
                    String reg_session = sh.getString("reg_session", "");
                    String check = regYe.getText().toString().trim();
                    String pwd =  regPaw.getText().toString().trim();
                    if(!TextUtils.isEmpty(pwd)&&pwd.length()>5){
                        String dev_id = Utlues.APP_dev_id(RegiesActivity.this);
                        int ver_code = Utlues.APP_ver_code(RegiesActivity.this);
                        String tick = Utlues.APP_tick();
                        String appkey =Utlues.getAppKey(con);
                        String priveKey =Utlues.getPrivateKey(con);
                        StringBuffer str = new StringBuffer();
                        str.append(priveKey)
                                .append(appkey)
                                .append(dev_id)
                                .append(ver_code)
                                .append(tick)
                                .append(reg_session)
                                .append(check)
                                .append(pwd);

                        //进行加密处理
                        String md5 = Utlues.APP_md5(str.toString());
                        String aCase = md5.toUpperCase();
                        MyServer server = Utlues.getMyServer(Api.BASE_URL3);
                        Flowable<MaBean> ma = server.getMa(appkey, dev_id, ver_code, tick, reg_session, check, pwd, aCase);
                        ma.subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribeWith(new DefaultSubscriber<MaBean>() {
                                    @Override
                                    public void onNext(MaBean maBean) {
                                        Toast.makeText(RegiesActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                                        Intent intent =new Intent(RegiesActivity.this,Log_Activity.class);
                                        intent.putExtra("name",regPhone.getText().toString());
                                        intent.putExtra("paw",regPaw.getText().toString());
                                        startActivity(intent);
                                        finish();
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


                break;
        }
    }


}
