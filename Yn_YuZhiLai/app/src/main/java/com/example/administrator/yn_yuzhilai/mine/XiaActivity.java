package com.example.administrator.yn_yuzhilai.mine;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.yn_yuzhilai.R;
import com.example.administrator.yn_yuzhilai.activity.Class2Activity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者：仝晓雅 on 2017/6/7 08:40
 * 类的注释：
 */

public class XiaActivity extends Activity {
    @Bind(R.id.i_fan)
    ImageView iFan;
    @Bind(R.id.i_text)
    TextView iText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.xia_main);
        ButterKnife.bind(this);
        iText.setText("我的下载");

    }

    @OnClick({R.id.i_fan, R.id.i_text})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.i_fan:
                Intent in =new Intent();
                XiaActivity.this.setResult(300,in);
                finish();
                break;
            case R.id.i_text:
                break;
        }
    }
}
