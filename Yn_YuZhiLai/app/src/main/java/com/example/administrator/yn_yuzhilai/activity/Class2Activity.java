package com.example.administrator.yn_yuzhilai.activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.yn_yuzhilai.R;
import com.example.administrator.yn_yuzhilai.bean.CateGroyBean;
import com.example.administrator.yn_yuzhilai.bean.OneJingBean;
import com.example.administrator.yn_yuzhilai.bean.OneKeBean;
import com.example.administrator.yn_yuzhilai.bean.OneMianBean;
import com.example.administrator.yn_yuzhilai.bean.OnePicBean;
import com.example.administrator.yn_yuzhilai.fragment.Cate2_f;
import com.example.administrator.yn_yuzhilai.fragment.Cate_f;
import com.example.administrator.yn_yuzhilai.s_mvp.persent.MyPresenters;
import com.example.administrator.yn_yuzhilai.s_mvp.view.MyView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * 作者：仝晓雅 on 2017/6/4 08:56
 * 类的注释：全部分类的课程
 */

public class Class2Activity extends BaseActivity implements MyView{


    @Bind(R.id.i_fan)
    ImageView iFan;
    @Bind(R.id.i_text)
    TextView iText;
    @Bind(R.id.c_tab)
    TabLayout cTab;
    @Bind(R.id.c_pager)
    ViewPager cPager;
    ArrayList<String> list =new ArrayList<>();
    private ArrayList<Cate2_f> f_list;
    private MyPresenters myPresenters;
    private int position;


    @Override
    public int initLayout() {
        return R.layout.cla_mamin;

    }

    @Override
    public void initView() {
        myPresenters = new MyPresenters(this,this);
        myPresenters.showDataBeann();
        Intent intent =getIntent();
        //name赋值
        String name = intent.getStringExtra("name");
        iText.setText(name);
        position = intent.getIntExtra("position", -1);

        //点击返回到上一个界面
        iFan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in =new Intent();
                Class2Activity.this.setResult(20,in);
                finish();
            }
        });
    }

    @Override
    public void getData() {


    }


    @Override
    public void showBanner(OnePicBean onePicBean) {

    }

    @Override
    public void showMian(OneMianBean oneMianBean) {

    }

    @Override
    public void showKe(OneKeBean oneKeBean) {

    }

    @Override
    public void showZhuan(OneJingBean oneJingBean) {

    }

    @Override
    public void showCateTab(CateGroyBean cateGroyBean) {
        List<CateGroyBean.DataBean.CategoryBean> category = cateGroyBean.getData().getCategory();
        for(int i=0;i<category.size();i++){
            String title = category.get(i).getTitle();
            list.add(title);
        }
        f_list = new ArrayList<>();
        for(int i =0;i<list.size();i++){
            Cate2_f fragmnets =new Cate2_f();

            f_list.add(fragmnets);

        }
        cTab.setTabMode(TabLayout.MODE_FIXED);
        MyPager my =new MyPager(getSupportFragmentManager());
        cPager.setAdapter(my);
        cTab.setTabsFromPagerAdapter(my);
        cTab.setupWithViewPager(cPager);
    }
    //pager适配器
    class MyPager extends FragmentPagerAdapter {


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
            return list.get(position);
        }
    }

}
