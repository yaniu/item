package com.example.administrator.yn_yuzhilai.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.yn_yuzhilai.R;
import com.example.administrator.yn_yuzhilai.adpater.Study_rec_ke;
import com.example.administrator.yn_yuzhilai.adpater.Study_rec_zhuan_x;
import com.example.administrator.yn_yuzhilai.bean.JingBean;
import com.example.administrator.yn_yuzhilai.bean.KeBean;
import com.example.administrator.yn_yuzhilai.x_mvp.persenter.X_MyPersenter;
import com.example.administrator.yn_yuzhilai.x_mvp.view.X_View;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者：仝晓雅 on 2017/6/3 11:30
 * 类的注释：
 */

public class Xiang_JActivity extends BaseActivity implements X_View{

    @Bind(R.id.j_x_fan)
    ImageView jXFan;
    @Bind(R.id.j_x_name)
    TextView jXName;
    @Bind(R.id.j_x_fen)
    ImageView jXFen;
    @Bind(R.id.k_x_lin)
    LinearLayout kXLin;
    @Bind(R.id.j_x_text1)
    TextView jXText1;
    @Bind(R.id.j_x_text2)
    TextView jXText2;
    @Bind(R.id.j_x_pic)
    ImageView jXPic;
    @Bind(R.id.j_x_xin)
    ImageView jXXin;
    @Bind(R.id.j_x_num)
    TextView jXNum;
    @Bind(R.id.j_x_text3)
    TextView jXText3;
    @Bind(R.id.j_x_text4)
    TextView jXText4;
    @Bind(R.id.j_x_rec)
    RecyclerView jXRec;

    @Override
    public int initLayout() {

        return R.layout.xiang_mk;
    }

    @Override
    public void initView() {

    }

    @Override
    public void getData() {
        Intent intent = getIntent();
        int position = intent.getIntExtra("position", -1);
       X_MyPersenter x_myPersenter  = new X_MyPersenter(this, this);
        x_myPersenter.getXiang(position);

    }



    @OnClick({R.id.j_x_fan, R.id.j_x_name, R.id.j_x_fen, R.id.k_x_lin, R.id.j_x_text1, R.id.j_x_text2, R.id.j_x_pic, R.id.j_x_xin, R.id.j_x_num, R.id.j_x_text3, R.id.j_x_text4, R.id.j_x_rec})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.j_x_fan:
                Intent in = new Intent();
                Xiang_JActivity.this.setResult(30, in);
                finish();
                break;
            case R.id.j_x_name:
                break;
            case R.id.j_x_fen:
                break;
            case R.id.k_x_lin:
                break;
            case R.id.j_x_text1:
                break;
            case R.id.j_x_text2:
                break;
            case R.id.j_x_pic:
                break;
            case R.id.j_x_xin:
                break;
            case R.id.j_x_num:
                break;
            case R.id.j_x_text3:
                break;
            case R.id.j_x_text4:
                break;
            case R.id.j_x_rec:
                break;
        }
    }

    @Override
    public void showKeXiang(KeBean keBean) {

    }

    @Override
    public void showZhuanXiang(JingBean jingBean) {
        List<JingBean.DataBean.CourseBean> course1 = jingBean.getData().getCourse();
        JingBean.DataBean data = jingBean.getData();
        jXText1.setText(data.getTitle());
        jXText2.setText(data.getTitle2());
        Glide.with(Xiang_JActivity.this).load(data.getTopic_image()).into(jXPic);
        List<JingBean.DataBean.CourseBean> course = data.getCourse();
        jXRec.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        Study_rec_zhuan_x rec =new Study_rec_zhuan_x(this,course);
        jXRec.setAdapter(rec);
        rec.setOnItemClickListener(new Study_rec_ke.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position,int price) {
                Intent intent =new Intent(Xiang_JActivity.this,Xiang_Activity.class);
                intent.putExtra("position",position);
                intent.putExtra("price",price);
                startActivityForResult(intent,30);
            }
        });
    }
}
