package com.example.administrator.yn_yuzhilai.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.yn_yuzhilai.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者：仝晓雅 on 2017/6/8 10:45
 * 类的注释：
 */

public class ChongActivity1 extends Activity {
    @Bind(R.id.i_fan)
    ImageView iFan;
    @Bind(R.id.i_text)
    TextView iText;
    @Bind(R.id.c_ping)
    CheckBox cPing;
    @Bind(R.id.c_wei)
    CheckBox cWei;
    @Bind(R.id.c_zhi)
    CheckBox cZhi;
    @Bind(R.id.c_yes)
    TextView cYes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mine_chong_1);
        ButterKnife.bind(this);
        iText.setText("充值");

    }

    @OnClick({R.id.i_fan, R.id.i_text, R.id.c_ping, R.id.c_wei, R.id.c_zhi, R.id.c_yes})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.i_fan:
                Intent in =new Intent();
                ChongActivity1.this.setResult(200,in);
                finish();
                break;
            case R.id.i_text:
                break;
            case R.id.c_ping:
                cPing.setChecked(true);
                cWei.setChecked(false);
                cZhi.setChecked(false);
                break;
            case R.id.c_wei:
                cPing.setChecked(false);
                cWei.setChecked(true);
                cZhi.setChecked(false);
                break;
            case R.id.c_zhi:
                cPing.setChecked(false);
                cWei.setChecked(false);
                cZhi.setChecked(true);
                break;
            case R.id.c_yes:
                if (cPing.isChecked()){
                    Toast.makeText(this, "苹果支付成功", Toast.LENGTH_SHORT).show();
                }else if (cWei.isChecked()){
                    Toast.makeText(this, "微信支付成功", Toast.LENGTH_SHORT).show();
                }else if (cZhi.isChecked()){
                    Toast.makeText(this, "支付宝支付成功", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
