package com.example.administrator.yn_yuzhilai.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.yn_yuzhilai.R;
import com.example.administrator.yn_yuzhilai.adpater.MyPager;
import com.example.administrator.yn_yuzhilai.bean.FirstHandBean;
import com.example.administrator.yn_yuzhilai.bean.TwoHandBean;
import com.example.administrator.yn_yuzhilai.tools.Api;
import com.example.administrator.yn_yuzhilai.tools.MyServer;
import com.example.administrator.yn_yuzhilai.tools.SharedpreferenceUtile;
import com.example.administrator.yn_yuzhilai.tools.Utlues;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DefaultSubscriber;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.viewpager)
    ViewPager viewpager;
    @Bind(R.id.activity_main)
    RelativeLayout activityMain;
    @Bind(R.id.p_num)
    TextView pNum;
    int num =4;
    private SharedPreferences.Editor edit;
   /* private SharedPreferences.Editor editor;
    public static SharedPreferences sharedPreferences;*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //SharedPreferences 记录是否第一次进入
        SharedPreferences sh =getSharedPreferences("con",MODE_PRIVATE);
        edit = sh.edit();
        boolean flag = sh.getBoolean("flag", false);
        if(flag){
            Intent intent =new Intent(MainActivity.this,TwoActivity.class);
            startActivity(intent);

        }else {
           /* sharedPreferences = getSharedPreferences("fist",MODE_PRIVATE);
            editor = sharedPreferences.edit();
            //获得首次安装的标识
            //  getData(Utlues.APP_tpye, Utlues.APP_dev_id(this), Utlues.APP_ver_code(this), Utlues.APP_tick());
            boolean isFirst = sharedPreferences.getBoolean("two", true);*/
            final ArrayList<ImageView> list = new ArrayList<>();
            int[] pic = new int[]{R.mipmap.image_1, R.mipmap.image_2, R.mipmap.image_3, R.mipmap.image_4};
            for (int i = 0; i < pic.length; i++) {
                ImageView imageView = new ImageView(this);
                imageView.setImageResource(pic[i]);
                list.add(imageView);
            }
            MyPager my = new MyPager(this, list);
            viewpager.setAdapter(my);
            viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                    if (position == (list.size() - 1)) {
                        Intent intent = new Intent(MainActivity.this, TwoActivity.class);
                        MainActivity.this.edit.putBoolean("flag", true);
                        MainActivity.this.edit.commit();
                        startActivity(intent);
                    }
                }
                @Override
                public void onPageSelected(int position) {
                    for (int i = 0; i < list.size(); i++) {
                        if (i == position % list.size()) {
                            num--;
                            pNum.setText(num + "");
                        }
                    }
                }
                @Override
                public void onPageScrollStateChanged(int state) {}
            });
        }
    }




    @OnClick({R.id.viewpager, R.id.activity_main,R.id.p_num})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.viewpager:
                break;
            case R.id.activity_main:
                break;
            case R.id.p_num:
                break;
        }
    }


}
