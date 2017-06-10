package com.example.administrator.yn_yuzhilai.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.yn_yuzhilai.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者：仝晓雅 on 2017/6/8 10:18
 * 类的注释：
 */

public class ChongActivity extends Activity {
    @Bind(R.id.i_fan)
    ImageView iFan;
    @Bind(R.id.i_text)
    TextView iText;
    @Bind(R.id.c_pirce)
    TextView cPirce;
    @Bind(R.id.c_price1)
    TextView cPrice1;
    @Bind(R.id.c_price2)
    TextView cPrice2;
    @Bind(R.id.c_price3)
    TextView cPrice3;
    @Bind(R.id.c_price4)
    TextView cPrice4;
    @Bind(R.id.c_price5)
    TextView cPrice5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mine_chongzhi);
        ButterKnife.bind(this);
        iText.setText("账户余额");

    }

    @OnClick({R.id.i_fan, R.id.i_text, R.id.c_pirce, R.id.c_price1, R.id.c_price2, R.id.c_price3, R.id.c_price4, R.id.c_price5})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.i_fan:
                Intent in =new Intent();
                ChongActivity.this.setResult(300,in);
                finish();
                break;
            case R.id.i_text:
                break;
            case R.id.c_pirce:
                Intent intent =new Intent(ChongActivity.this,ChongActivity1.class);
                startActivity(intent);

                break;
            case R.id.c_price1:
                Intent intent1 =new Intent(ChongActivity.this,ChongActivity1.class);
                startActivity(intent1);

                break;
            case R.id.c_price2:
                Intent intent2 =new Intent(ChongActivity.this,ChongActivity1.class);
                startActivity(intent2);
                break;
            case R.id.c_price3:
                Intent intent3 =new Intent(ChongActivity.this,ChongActivity1.class);
                startActivity(intent3);
                break;
            case R.id.c_price4:
                Intent intent4 =new Intent(ChongActivity.this,ChongActivity1.class);
                startActivity(intent4);
                break;
            case R.id.c_price5:
                Intent intent5 =new Intent(ChongActivity.this,ChongActivity1.class);
                startActivity(intent5);
                break;
        }
    }
}
