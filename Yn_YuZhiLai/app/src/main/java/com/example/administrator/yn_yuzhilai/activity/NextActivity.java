package com.example.administrator.yn_yuzhilai.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.administrator.yn_yuzhilai.R;
import com.example.administrator.yn_yuzhilai.fragment.Course_f;
import com.example.administrator.yn_yuzhilai.fragment.Mine_f;
import com.example.administrator.yn_yuzhilai.fragment.Study_f;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者：仝晓雅 on 2017/6/2 10:29
 * 类的注释：
 */

public  class NextActivity extends AppCompatActivity {

    @Bind(R.id.y_fragment)
    FrameLayout yFragment;
    @Bind(R.id.y_study)
    RadioButton yStudy;
    @Bind(R.id.y_course)
    RadioButton yCourse;
    @Bind(R.id.y_mine)
    RadioButton yMine;
    @Bind(R.id.y_radioGroup)
    RadioGroup yRadioGroup;
    private FragmentManager manager;
    private Course_f course_f;
    private Mine_f mine_f;
    private Study_f study_f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.next_main);
        ButterKnife.bind(this);
        course_f = new Course_f();
        mine_f = new Mine_f();
        study_f = new Study_f();
        //添加Fragment 获取FragmentManager
        manager = getSupportFragmentManager();
        //开启事物
        FragmentTransaction transaction = manager.beginTransaction();
        //fragment进行添加
        transaction.add(R.id.y_fragment, course_f);
        transaction.add(R.id.y_fragment, study_f);
        transaction.add(R.id.y_fragment, mine_f);
        //fragment进行隐藏
        transaction.hide(course_f);
        transaction.hide(mine_f);
        //一定要记住提交
        transaction.commit();
        //RadioButton设置点击
        yStudy.setSelected(true);
        yCourse.setSelected(false);
        yMine.setSelected(false);


    }

    @OnClick({R.id.y_fragment, R.id.y_study, R.id.y_course, R.id.y_mine, R.id.y_radioGroup})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.y_fragment:
                break;
            case R.id.y_study:
                show(study_f,course_f,mine_f);
                yStudy.setSelected(true);
                yCourse.setSelected(false);
                yMine.setSelected(false);
                break;
            case R.id.y_course:
                yCourse.setSelected(true);
                yStudy.setSelected(false);
                yMine.setSelected(false);
                show(course_f,study_f,mine_f);
                break;
            case R.id.y_mine:
                yMine.setSelected(true);
                yStudy.setSelected(false);
                yCourse.setSelected(false);
                show(mine_f,course_f,study_f);
                break;
            case R.id.y_radioGroup:
                break;
        }
    }
    //写一个显示和隐藏的方法
    public void show(Fragment f1, Fragment f2, Fragment f3){
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.show(f1);
        transaction.hide(f2);
        transaction.hide(f3);
        transaction.commit();
    }
}
