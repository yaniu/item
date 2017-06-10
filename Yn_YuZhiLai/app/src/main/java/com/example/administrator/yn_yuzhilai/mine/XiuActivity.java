package com.example.administrator.yn_yuzhilai.mine;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.administrator.yn_yuzhilai.R;
import com.example.administrator.yn_yuzhilai.bean.XiuBean;

import org.greenrobot.eventbus.EventBus;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者：仝晓雅 on 2017/6/7 20:12
 * 类的注释：
 */

public class XiuActivity extends Activity {

    @Bind(R.id.i_fan)
    ImageView iFan;
    @Bind(R.id.i_text)
    TextView iText;
    @Bind(R.id.xiu_pic1)
    ImageView xiuPic1;
    @Bind(R.id.xiu_tou)
    ImageView xiuTou;
    @Bind(R.id.xiu_pic)
    LinearLayout xiuPic;
    @Bind(R.id.xiu_name)
    EditText xiuName;
    @Bind(R.id.xiu_phone)
    EditText xiuPhone;
    @Bind(R.id.xiu_weixin)
    LinearLayout xiuWeixin;
    @Bind(R.id.xiu_button)
    ImageView xiuButton;
    private  String path ="http://img.17gexing.com/uploadfile/2016/08/2/20160826114041327.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xiu_main);
        ButterKnife.bind(this);
        iText.setText("我的个人账户");

    }

    @OnClick({R.id.i_fan, R.id.i_text, R.id.xiu_pic1,R.id.xiu_tou, R.id.xiu_pic, R.id.xiu_name, R.id.xiu_phone, R.id.xiu_weixin, R.id.xiu_button})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.i_fan:
                Intent in =new Intent();
                XiuActivity.this.setResult(200,in);
                finish();
                break;
            case R.id.i_text:
                break;
            case R.id.xiu_tou:


                break;
            case R.id.m_pic1:
                break;
            case R.id.xiu_pic:
                //将图片设置成圆形
                Glide.with(XiuActivity.this).load(path).asBitmap().centerCrop().into(new BitmapImageViewTarget(xiuTou)
                {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable circularBitmapDrawable =
                                RoundedBitmapDrawableFactory.create(XiuActivity.this.getResources(), resource);
                        circularBitmapDrawable.setCircular(true);
                        xiuTou.setImageDrawable(circularBitmapDrawable);
                    }
                }
                );
                break;
            case R.id.xiu_name:

                break;
            case R.id.xiu_phone:
                break;
            case R.id.xiu_weixin:
                break;
            case R.id.xiu_button:
                String string = xiuName.getText().toString();
                XiuBean xiu =new XiuBean();
                xiu.name =string;
                xiu.name1="普通会员";
                xiu.url=path;

                EventBus.getDefault().post(xiu);
                finish();
                break;
        }
    }
}
