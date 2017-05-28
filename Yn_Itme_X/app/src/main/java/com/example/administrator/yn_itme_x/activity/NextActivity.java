package com.example.administrator.yn_itme_x.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.administrator.yn_itme_x.R;
import com.example.administrator.yn_itme_x.fragment_s.Fragmnets;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者：仝晓雅 on 2017/5/23 21:30
 * 类的注释：点击查看全部进来的界面
 */

public class NextActivity extends FragmentActivity {
    @Bind(R.id.n_fan)
    ImageView nFan;
    @Bind(R.id.n_text)
    TextView nText;
    @Bind(R.id.n_tab)
    TabLayout nTab;
    @Bind(R.id.n_pager)
    ViewPager nPager;
    @Bind(R.id.n_time)
    TextView nTime;
    @Bind(R.id.n_times)
    ImageView nTimes;
    @Bind(R.id.n_lin)
    LinearLayout nLin;
    private ArrayList<Fragmnets> f_list;
    private ArrayList<String> t_list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.next_main);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        //传过来的值进行赋值
        String name = intent.getStringExtra("name");
        boolean time = intent.getBooleanExtra("time", false);
        nText.setText(name);
        if (time == true) {
            nLin.setVisibility(View.VISIBLE);
        }
        t_list = new ArrayList<>();
        String [] table =new String []{"精选","美容","美甲","按摩","培训"};
        for(int i =0;i<5;i++){
            t_list.add(table[i]);
        }
        f_list = new ArrayList<>();
        for(int i =0;i<table.length;i++){
            Fragmnets fragmnets =new Fragmnets();
            f_list.add(fragmnets);

        }
        nTab.setTabMode(TabLayout.MODE_FIXED);
        MyPager my =new MyPager(getSupportFragmentManager());
        nPager.setAdapter(my);
        nTab.setTabsFromPagerAdapter(my);
        nTab.setupWithViewPager(nPager);




    }
    class MyPager extends FragmentPagerAdapter{


        public MyPager(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return f_list.get(position);
        }

        @Override
        public int getCount() {
            return f_list.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return t_list.get(position);
        }
    }

    @OnClick({R.id.n_fan, R.id.n_text, R.id.n_tab, R.id.n_pager, R.id.n_time, R.id.n_times, R.id.n_lin})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.n_fan:
                Intent in =new Intent();
                NextActivity.this.setResult(20,in);
                finish();
                break;
            case R.id.n_text:
                break;
            case R.id.n_tab:
                break;
            case R.id.n_pager:

                break;
            case R.id.n_time:
                break;
            case R.id.n_times:
                break;
            case R.id.n_lin:
                nTime.setTextColor(Color.parseColor("#0568e1"));
                nTimes.setSelected(true);
                showPopupWindow();
                break;

        }
    }

    //点击按时间进行排序弹出PopupWindow
    private void showPopupWindow() {
        View contentView = LayoutInflater.from(NextActivity.this).inflate(R.layout.time_pop, null);

        final PopupWindow mPopWindow = new PopupWindow(contentView);
        mPopWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        mPopWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        final TextView tv1 = (TextView)contentView.findViewById(R.id.p_text1);
        final TextView tv2 = (TextView)contentView.findViewById(R.id.p_text2);
        mPopWindow.showAsDropDown(nLin);
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nTime.setText("按上架");
                mPopWindow.dismiss();
            }
        });
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nTime.setText("按七日");
                mPopWindow.dismiss();
            }
        });


    }


}
