package com.example.administrator.yn_yuzhilai.mine;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.yn_yuzhilai.R;
import com.example.administrator.yn_yuzhilai.activity.LogActivity;
import com.example.administrator.yn_yuzhilai.bean.CallBean;
import com.example.administrator.yn_yuzhilai.bean.ShouLieBean;
import com.example.administrator.yn_yuzhilai.bean.ZhuBean;
import com.example.administrator.yn_yuzhilai.mine.shou_mvp.Shou_MyPersenter;
import com.example.administrator.yn_yuzhilai.mine.shou_mvp.Shou_View;
import com.example.administrator.yn_yuzhilai.tools.SharedpreferenceUtile;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者：仝晓雅 on 2017/6/7 08:40
 * 类的注释：
 */

public class SheActivity extends Activity {


    @Bind(R.id.i_fan)
    ImageView iFan;
    @Bind(R.id.i_text)
    TextView iText;
    @Bind(R.id.she_text1)
    LinearLayout sheText1;
    @Bind(R.id.textView)
    TextView textView;
    @Bind(R.id.she_text2)
    ImageView sheText2;
    @Bind(R.id.she_text3)
    ImageView sheText3;
    @Bind(R.id.she_text4)
    TextView sheText4;
    @Bind(R.id.she_text5)
    LinearLayout sheText5;
    @Bind(R.id.she_text6)
    LinearLayout sheText6;
    @Bind(R.id.she_text7)
    LinearLayout sheText7;
    @Bind(R.id.she_text8)
    LinearLayout sheText8;
    @Bind(R.id.she_text9)
    LinearLayout sheText9;
    @Bind(R.id.she_text10)
    TextView sheText10;
    boolean falg =false;
    private SharedPreferences.Editor edit;
    private SharedPreferences zhu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.she_main);
        ButterKnife.bind(this);
        iText.setText("设置中心");
/*
        Shou_MyPersenter shou_myPersenter =new Shou_MyPersenter(this,this);
        shou_myPersenter.showlie();
        zhu = getSharedPreferences("zhuxiao", MODE_PRIVATE);
        edit = zhu.edit();
*/




    }


    @OnClick({R.id.i_fan, R.id.i_text, R.id.she_text1, R.id.textView, R.id.she_text2, R.id.she_text3, R.id.she_text4, R.id.she_text5, R.id.she_text6, R.id.she_text7, R.id.she_text8, R.id.she_text9, R.id.she_text10})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.i_fan:
                Intent in =new Intent();
                SheActivity.this.setResult(300,in);
                finish();
                break;
            case R.id.i_text:
                break;
            case R.id.she_text1:
                break;
            case R.id.textView:
                break;
            case R.id.she_text2:
                if(falg){
                    sheText2.setSelected(false);
                }else{
                    sheText2.setSelected(true);

                }
                falg=!falg;


                break;
            case R.id.she_text3:
                if(falg){
                    sheText3.setSelected(false);

                }else{
                    sheText3.setSelected(true);

                }
                falg=!falg;
                break;
            case R.id.she_text4:
                break;
            case R.id.she_text5:
                break;
            case R.id.she_text6:
                break;
            case R.id.she_text7:
                break;
            case R.id.she_text8:
                break;
            case R.id.she_text9:
                break;
            case R.id.she_text10:
               /* boolean zhus =zhu.getBoolean("zhu", false);
                if(zhus){
                    Toast.makeText(this, "注销成功", Toast.LENGTH_SHORT).show();
                  *//*  Intent ins =new Intent(SheActivity.this, LogActivity.class);
                    startActivity(ins);*//*
                }*/
                break;
        }
    }

   /* @Override
    public void showShow(ShouLieBean shouLieBean) {

    }

    @Override
    public void showCall(CallBean callBean) {

    }

    @Override
    public void showLog(ZhuBean zhuBean) {
         boolean logout = zhuBean.getData().isLogout();
        Log.i("true",logout+"");
        edit.putBoolean("zhu",logout);
        edit.commit();


    }*/
}
