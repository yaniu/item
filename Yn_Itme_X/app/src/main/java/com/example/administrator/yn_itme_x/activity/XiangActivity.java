package com.example.administrator.yn_itme_x.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.yn_itme_x.R;
import com.example.administrator.yn_itme_x.apdate.Study_rec_zhuan_x;
import com.example.administrator.yn_itme_x.bean.JingBean;
import com.example.administrator.yn_itme_x.xiang_z.X_MyPersent;
import com.example.administrator.yn_itme_x.xiang_z.X_View;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者：仝晓雅 on 2017/5/26 16:37
 * 类的注释：详情界面
 */

public class XiangActivity extends Activity implements X_View {
    @Bind(R.id.z_x_pic)
    ImageView zXPic;
    @Bind(R.id.z_x_fan)
    ImageView zXFan;
    @Bind(R.id.n_text)
    TextView nText;
    @Bind(R.id.z_x_fen)
    ImageView zXFen;
    @Bind(R.id.z_x_text1)
    TextView zXText1;
    @Bind(R.id.z_x_text2)
    TextView zXText2;
    @Bind(R.id.z_x_xin)
    ImageView zXXin;
    @Bind(R.id.z_x_num)
    TextView zXNum;
    @Bind(R.id.z_x_text3)
    TextView zXText3;
    @Bind(R.id.z_x_text4)
    TextView zXText4;
    @Bind(R.id.z_x_rec)
    RecyclerView zXRec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xiang_mian);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        int position = intent.getIntExtra("position", -1);
        X_MyPersent x_myPersent = new X_MyPersent(this, this);
        x_myPersent.showXiangZhuanToView(position);


    }

    @Override
    public void show(JingBean jingBean) {
        JingBean.DataBean data = jingBean.getData();
        zXText1.setText(data.getTitle());
        zXText2.setText(data.getTitle2());
        Glide.with(XiangActivity.this).load(data.getTopic_image()).into(zXPic);
        List<JingBean.DataBean.CourseBean> course = data.getCourse();
        zXRec.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        Study_rec_zhuan_x rec =new Study_rec_zhuan_x(this,course);
        zXRec.setAdapter(rec);
        String object_id = data.getObject_id();
        Log.i("sadsadsa",object_id);


    }

    @OnClick({R.id.z_x_pic, R.id.z_x_fan, R.id.n_text, R.id.z_x_fen, R.id.z_x_text1, R.id.z_x_text2, R.id.z_x_xin, R.id.z_x_num, R.id.z_x_text3, R.id.z_x_text4, R.id.z_x_rec})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.z_x_pic:
                break;
            case R.id.z_x_fan:
                Intent in =new Intent();
                XiangActivity.this.setResult(30,in);
                finish();
                break;
            case R.id.n_text:
                break;
            case R.id.z_x_fen:
                break;
            case R.id.z_x_text1:
                break;
            case R.id.z_x_text2:
                break;
            case R.id.z_x_xin:
                break;
            case R.id.z_x_num:
                break;
            case R.id.z_x_text3:
                break;
            case R.id.z_x_text4:
                break;
            case R.id.z_x_rec:
                break;
        }
    }
}
