package com.example.administrator.yn_itme_x.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.yn_itme_x.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者：仝晓雅 on 2017/5/28 10:30
 * 类的注释：登录界面
 */

public class Log_Activity extends Activity {

    @Bind(R.id.log_fan)
    ImageView logFan;
    @Bind(R.id.log_phone)

    EditText logPhone;
    @Bind(R.id.log_paw)
    EditText logPaw;
    @Bind(R.id.log_yan)
    ImageView logYan;
    @Bind(R.id.log_wang)
    TextView logWang;
    @Bind(R.id.log)
    Button log;
    @Bind(R.id.reg)
    Button reg;
    @Bind(R.id.log_she)
    TextView logShe;
    @Bind(R.id.log_wei)
    ImageView logWei;
    @Bind(R.id.tv1)
    TextView tv1;
    @Bind(R.id.log_weixin)
    RelativeLayout logWeixin;
    @Bind(R.id.iv2)
    ImageView iv2;
    @Bind(R.id.tv2)
    TextView tv2;
    @Bind(R.id.log_qq)
    RelativeLayout logQq;
    private String name;
    private String paw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        Intent intent =getIntent();
        name = intent.getStringExtra("name");
        paw = intent.getStringExtra("paw");
        logPhone.setText(name);
        logPaw.setText(paw);

    }

    @OnClick({R.id.log_fan, R.id.log_phone, R.id.log_paw, R.id.log_yan, R.id.log_wang, R.id.log, R.id.reg, R.id.log_she, R.id.log_wei, R.id.tv1, R.id.log_weixin, R.id.iv2, R.id.tv2, R.id.log_qq})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.log_fan:
                break;
            case R.id.log_phone:
                break;
            case R.id.log_paw:
                break;
            case R.id.log_yan:
                break;
            case R.id.log_wang:
                break;
            case R.id.log:
                if(logPhone.getText().toString().equals(name)&&logPaw.getText().toString().equals(paw)){
                    Intent intent =new Intent(Log_Activity.this,ZhiActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(this, "主人，请先注册哈~~", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.reg:
                Intent intent =new Intent(Log_Activity.this,RegiesActivity.class);
                startActivity(intent);
                break;
            case R.id.log_she:
                break;
            case R.id.log_wei:
                break;
            case R.id.tv1:
                break;
            case R.id.log_weixin:
                break;
            case R.id.iv2:
                break;
            case R.id.tv2:
                break;
            case R.id.log_qq:
                break;
        }
    }
}
