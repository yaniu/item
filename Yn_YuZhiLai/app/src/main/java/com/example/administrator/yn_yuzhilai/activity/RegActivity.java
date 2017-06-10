package com.example.administrator.yn_yuzhilai.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.yn_yuzhilai.R;
import com.example.administrator.yn_yuzhilai.bean.MaBean;
import com.example.administrator.yn_yuzhilai.bean.RegBean;
import com.example.administrator.yn_yuzhilai.tools.MyServer;
import com.example.administrator.yn_yuzhilai.tools.SharedpreferenceUtile;
import com.example.administrator.yn_yuzhilai.tools.Utlues;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DefaultSubscriber;

/**
 * 作者：仝晓雅 on 2017/6/6 14:58
 * 类的注释：
 */

public class RegActivity extends Activity {
    @Bind(R.id.reg_phone)
    EditText regPhone;
    @Bind(R.id.reg_num)
    EditText regNum;
    @Bind(R.id.reg_getnum)
    TextView regGetnum;
    @Bind(R.id.reg_paw)
    EditText regPaw;
    @Bind(R.id.reg_button)
    Button regButton;
    @Bind(R.id.iv_tick)
    ImageView ivTick;

    private SharedPreferences sh;
    private String pwd;
    private SharedPreferences.Editor edit1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        ButterKnife.bind(this);
        sh=getSharedPreferences("log",MODE_PRIVATE);
        edit1 = sh.edit();
    }

    @OnClick({R.id.reg_phone, R.id.reg_num, R.id.reg_getnum, R.id.reg_paw, R.id.reg_button, R.id.iv_tick})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.reg_phone:
                break;
            case R.id.reg_num:
                break;
            case R.id.reg_getnum:
                String mobile = regPhone.getText().toString().trim();
                if(!TextUtils.isEmpty(mobile)&&mobile.length()==11) {
                    String dev_id = Utlues.APP_dev_id(RegActivity.this);
                    int ver_code = Utlues.APP_ver_code(RegActivity.this);
                    String tick = Utlues.APP_tick();
                    String appkey = SharedpreferenceUtile.getInstance().getID();
                    String priveKey =SharedpreferenceUtile.getInstance().getKEY();
                    StringBuffer str = new StringBuffer();
                    str.append(priveKey)
                            .append(appkey)
                            .append(dev_id)
                            .append(ver_code)
                            .append(tick)
                            .append(mobile);
                    //进行加密处理
                    String md5 = Utlues.APP_md5(str.toString());
                    String aCase = md5.toUpperCase();
                    MyServer myServer = Utlues.getMyServer(SharedpreferenceUtile.getInstance().getBase());
                    Flowable<RegBean> reg = myServer.getReg(appkey, dev_id, ver_code, tick, mobile, aCase);
                    reg.subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribeWith(new DefaultSubscriber<RegBean>() {
                                @Override
                                public void onNext(RegBean regBean) {
                                    String session = regBean.getData().getSession();

                                    regNum.setText("9998");
                                    edit1.putString("reg_session", session);
                                    edit1.putBoolean("flag", true);
                                    edit1.commit();

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
            case R.id.reg_button:
                boolean flag = sh.getBoolean("flag", false);
                if(flag){
                    String reg_session = sh.getString("reg_session", "");
                    String check = regNum.getText().toString().trim();
                    String pwd =  regPaw.getText().toString().trim();
                    if(!TextUtils.isEmpty(pwd)&&pwd.length()>5){
                        String dev_id = Utlues.APP_dev_id(RegActivity.this);
                        int ver_code = Utlues.APP_ver_code(RegActivity.this);
                        String tick = Utlues.APP_tick();
                        String appkey =SharedpreferenceUtile.getInstance().getID();
                        String priveKey =SharedpreferenceUtile.getInstance().getKEY();
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
                        MyServer server = Utlues.getMyServer(SharedpreferenceUtile.getInstance().getBase());
                        Flowable<MaBean> ma = server.getMa(appkey, dev_id, ver_code, tick, reg_session, check, pwd, aCase);
                        ma.subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribeWith(new DefaultSubscriber<MaBean>() {
                                    @Override
                                    public void onNext(MaBean maBean) {
                                        Toast.makeText(RegActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                                        Intent intent =new Intent(RegActivity.this,LogActivity.class);
                                        startActivity(intent);
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
            case R.id.iv_tick:
                break;
        }
    }
}
