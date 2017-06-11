package com.example.administrator.yn_itme_x.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.yn_itme_x.R;
import com.example.administrator.yn_itme_x.bean.KeBean;
import com.example.administrator.yn_itme_x.xiang_k.K_MyPersent;
import com.example.administrator.yn_itme_x.xiang_k.K_View;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * 作者：仝晓雅 on 2017/5/26 20:40
 * 类的注释：
 */

public class Xiang_KActivity extends Activity implements K_View {

    @Bind(R.id.k_x_fan)
    ImageView kXFan;
    @Bind(R.id.k_x_text1)
    TextView kXText1;
    @Bind(R.id.k_x_fen)
    ImageView kXFen;
    @Bind(R.id.k_x_jc)
    JCVideoPlayerStandard kXJc;
    @Bind(R.id.linear_more)
    RelativeLayout linearMore;
    @Bind(R.id.k_x_pic1)
    ImageView kXPic1;
    @Bind(R.id.k_x_text2)
    TextView kXText2;
    @Bind(R.id.k_x_text3)
    TextView kXText3;
    @Bind(R.id.k_x_text4)
    TextView kXText4;
    @Bind(R.id.k_x_text5)
    TextView kXText5;
    @Bind(R.id.k_x_text6)
    TextView kXText6;
    @Bind(R.id.k_x_text7)
    TextView kXText7;
    @Bind(R.id.k_x_text8)
    TextView kXText8;
    @Bind(R.id.name_more3)
    TextView nameMore3;
    @Bind(R.id.more_rec)
    RecyclerView moreRec;
    @Bind(R.id.more_scro)
    NestedScrollView moreScro;
    @Bind(R.id.k_x_pic2)
    ImageView kXPic2;
    @Bind(R.id.k_x_pic3)
    ImageView kXPic3;
    @Bind(R.id.k_x_pic4)
    ImageView kXPic4;
    @Bind(R.id.k_x_text9)
    ImageView kXText9;
    @Bind(R.id.k_x_name)
    TextView kXName;
    @Bind(R.id.k_x_mai)
    TextView kXMai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.more_activity);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        int position = intent.getIntExtra("position", -1);
        K_MyPersent persent = new K_MyPersent(this, this);
        persent.showXiangKeToView(position);

    }

    @Override
    public void show(KeBean keBean) {
        KeBean.DataBean data = keBean.getData();
        kXText1.setText(data.getTitle());
        kXName.setText(data.getTitle());
        kXText2.setText(data.getTitle());
        kXText3.setText(data.getTitle2());
        Glide.with(this).load(data.getSpeaker_head()).into(kXPic1);
        kXText7.setText("已售：" + data.getTry_length());
        kXText8.setText(data.getAbstractX());
        String video = data.getCourse_video();
        boolean up = kXJc.setUp(video, "啦啦啦拉拉拉拉", "");
        if (up) {
            kXJc.thumbImageView.setImageResource(R.mipmap.course_video);
        }

    }

    @OnClick({R.id.k_x_fan, R.id.k_x_text1, R.id.k_x_fen, R.id.k_x_jc, R.id.linear_more, R.id.k_x_pic1, R.id.k_x_text2, R.id.k_x_text3, R.id.k_x_text4, R.id.k_x_text5, R.id.k_x_text6, R.id.k_x_text7, R.id.k_x_text8, R.id.name_more3, R.id.more_rec, R.id.more_scro, R.id.k_x_pic2, R.id.k_x_pic3, R.id.k_x_pic4, R.id.k_x_text9, R.id.k_x_name, R.id.k_x_mai})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.k_x_fan:
                Intent in = new Intent();
                Xiang_KActivity.this.setResult(30, in);
                finish();
                break;
            case R.id.k_x_text1:
                break;
            case R.id.k_x_fen:
                break;
            case R.id.k_x_jc:
                break;
            case R.id.linear_more:
                break;
            case R.id.k_x_pic1:
                break;
            case R.id.k_x_text2:
                break;
            case R.id.k_x_text3:
                break;
            case R.id.k_x_text4:
                break;
            case R.id.k_x_text5:
                break;
            case R.id.k_x_text6:
                break;
            case R.id.k_x_text7:
                break;
            case R.id.k_x_text8:
                break;
            case R.id.name_more3:
                break;
            case R.id.more_rec:
                break;
            case R.id.more_scro:
                break;
            case R.id.k_x_pic2:
                break;
            case R.id.k_x_pic3:
                break;
            case R.id.k_x_pic4:
                break;
            case R.id.k_x_text9:
                break;
            case R.id.k_x_name:
                break;
            case R.id.k_x_mai:
                Intent intent =new Intent(Xiang_KActivity.this,Log_Activity.class);
                startActivity(intent);
                break;
        }
    }
}
