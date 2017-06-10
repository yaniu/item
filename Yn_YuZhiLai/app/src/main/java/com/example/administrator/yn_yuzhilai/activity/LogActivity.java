package com.example.administrator.yn_yuzhilai.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.yn_yuzhilai.R;
import com.example.administrator.yn_yuzhilai.bean.User_LoginBean;
import com.example.administrator.yn_yuzhilai.tools.Api;
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
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * 作者：仝晓雅 on 2017/6/6 14:57
 * 类的注释：
 */

public class LogActivity extends Activity {
    @Bind(R.id.i_fan)
    ImageView iFan;
    @Bind(R.id.i_text)
    TextView iText;
    @Bind(R.id.log_phone)
    EditText logPhone;
    @Bind(R.id.log_paw)
    EditText logPaw;
    @Bind(R.id.log_no)
    TextView logNo;
    @Bind(R.id.log)
    Button log;
    @Bind(R.id.log_phone2)
    Button logPhone2;
    @Bind(R.id.iv1)
    ImageView iv1;
    @Bind(R.id.tv1)
    TextView tv1;
    @Bind(R.id.log_wei)
    LinearLayout logWei;
    @Bind(R.id.iv2)
    ImageView iv2;
    @Bind(R.id.tv2)
    TextView tv2;
    @Bind(R.id.log_qq)
    LinearLayout logQq;
    private int xing;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        iText.setText("登录界面");
        Intent intent =getIntent();
       xing =intent.getIntExtra("position",-1);



    }

    @OnClick({R.id.i_fan, R.id.i_text, R.id.log_phone, R.id.log_paw, R.id.log_no, R.id.log, R.id.log_phone2, R.id.iv1, R.id.tv1, R.id.log_wei, R.id.iv2, R.id.tv2, R.id.log_qq})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.i_fan:
                if(xing==1){
                    Intent in =new Intent();
                    in.putExtra("boolean",true);
                    LogActivity.this.setResult(2,in);
                    Log.i("log","dsdsad");
                    finish();
                }else if(xing==2){
                    Intent in =new Intent();
                    LogActivity.this.setResult(200,in);
                    finish();
                }
                break;
            case R.id.i_text:
                break;
            case R.id.log_phone:
                break;
            case R.id.log_paw:
                break;
            case R.id.log_no:
                break;
            case R.id.log:
                   Login();
                break;
            case R.id.log_phone2:
                Intent in =new Intent(LogActivity.this,RegActivity.class);
                startActivity(in);
                break;
            case R.id.iv1:
                break;
            case R.id.tv1:
                break;
            case R.id.log_wei:
                Toast.makeText(this, "微信登录", Toast.LENGTH_SHORT).show();
                break;
            case R.id.iv2:
                break;
            case R.id.tv2:
                break;
            case R.id.log_qq:
                Toast.makeText(this, "QQ登录", Toast.LENGTH_SHORT).show();
                break;
        }
    }
    private void Login() {
       String login_account = logPhone.getText().toString();
      String  login_password = logPaw.getText().toString();
        if (!TextUtils.isEmpty(login_account) && !TextUtils.isEmpty(login_password)) {
            try {
                String private_key = SharedpreferenceUtile.getInstance().getKEY();
                String app_id = SharedpreferenceUtile.getInstance().getID();
                String dev_id = Utlues.APP_dev_id(LogActivity.this);
                int ver_code = Utlues.APP_ver_code(LogActivity.this);
                String tick = Utlues.APP_tick();

                StringBuilder sb = new StringBuilder();
                sb.append(private_key).append(app_id)
                        .append(dev_id).append(ver_code)
                        .append(tick).append(login_account)
                        .append(login_password);
                String md5 = Utlues.APP_md5(sb.toString());
                String aCase = md5.toUpperCase();
                MyServer server = Utlues.getMyServer(SharedpreferenceUtile.getInstance().getBase());
                Flowable<User_LoginBean> flowable = server.
                        getLog(app_id, dev_id, ver_code, tick, login_account, login_password, aCase);

                flowable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new DisposableSubscriber<User_LoginBean>() {
                            @Override
                            public void onNext(User_LoginBean user_loginBean) {
                                if (user_loginBean.ret == -5){
                                    Toast.makeText(LogActivity.this, "手机号未注册", Toast.LENGTH_SHORT).show();
                                }else if (user_loginBean.ret == -7){
                                    Toast.makeText(LogActivity.this, "密码错误", Toast.LENGTH_SHORT).show();
                                }else if (user_loginBean.ret == -9){
                                    Toast.makeText(LogActivity.this, "连续密码错误5次，账户锁定15分钟", Toast.LENGTH_SHORT).show();
                                }else if (user_loginBean.ret == -10){
                                    Toast.makeText(LogActivity.this, "手机号码格式错误", Toast.LENGTH_SHORT).show();
                                }else if(user_loginBean.ret == 0){
                                    SharedPreferences.Editor edit =SharedpreferenceUtile.getInstance().getSh().edit();
                                    edit.putString("session", user_loginBean.data.session);
                                    edit.putBoolean("login_boolean",true);
                                    edit.commit();
                                    Log.i("ssssss",user_loginBean.data.session);
                                    Log.i("sss",SharedpreferenceUtile.getInstance().getBaseSession());
                                        Toast.makeText(LogActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
                                        if(xing==1){
                                       /* Intent intentx =new Intent(LogActivity.this,Xiang_Activity.class);
                                        startActivity(intentx);
                                        finish();*/
                                        Intent in =new Intent();
                                        in.putExtra("boolean",true);
                                        LogActivity.this.setResult(2,in);
                                        Log.i("log","dsdsad");
                                        finish();
                                    }else if(xing==2){
                                        Intent in =new Intent();
                                         in.putExtra("mname","已登录");
                                        LogActivity.this.setResult(200,in);
                                        finish();
                                    }

                                }
                            }
                            @Override
                            public void onError(Throwable t) {}
                            @Override
                            public void onComplete() {
                            }
                        });


            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            Toast.makeText(LogActivity.this, "账号密码不能为空", Toast.LENGTH_SHORT).show();
        }
    }



}
