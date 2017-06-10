package com.example.administrator.yn_yuzhilai.activity;

import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.administrator.yn_yuzhilai.R;
import com.example.administrator.yn_yuzhilai.bean.FirstHandBean;
import com.example.administrator.yn_yuzhilai.bean.TwoHandBean;
import com.example.administrator.yn_yuzhilai.fragment.Course_f;
import com.example.administrator.yn_yuzhilai.fragment.Mine_f;
import com.example.administrator.yn_yuzhilai.fragment.Study_f;
import com.example.administrator.yn_yuzhilai.tools.Api;
import com.example.administrator.yn_yuzhilai.tools.MyServer;
import com.example.administrator.yn_yuzhilai.tools.SharedpreferenceUtile;
import com.example.administrator.yn_yuzhilai.tools.Utlues;

import butterknife.Bind;
import butterknife.OnClick;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DefaultSubscriber;

/**
 * 作者：仝晓雅 on 2017/6/2 17:00
 * 类的注释：主界面
 */

public class TwoActivity extends BaseActivity {
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
    private Course_f course_f;
    private Mine_f mine_f;
    private Study_f study_f;
    private FragmentManager manager;
    private SharedPreferences.Editor editor;
    public static SharedPreferences sharedPreferences;
    @Override
    public int initLayout() {
        return R.layout.next_main;
    }

    @Override
    public void initView() {
        sharedPreferences = getSharedPreferences("fist",MODE_PRIVATE);
        editor = sharedPreferences.edit();
        //获得首次安装的标识
        //  getData(Utlues.APP_tpye, Utlues.APP_dev_id(this), Utlues.APP_ver_code(this), Utlues.APP_tick());
        boolean isFirst = sharedPreferences.getBoolean("two", true);
        if (isFirst) {//表示是第一次
            getDatas(Utlues.APP_tpye, Utlues.APP_dev_id(this), Utlues.APP_ver_code(this), Utlues.APP_tick());
        } else {
            //如果不是第一次  不会握手  也不会重新获得url
            // presenterClass.getUrlFromModle();
            getTwo(SharedpreferenceUtile.getInstance().getKEY(),
                    SharedpreferenceUtile.getInstance().getID(),
                    Utlues.APP_dev_id(TwoActivity.this),
                    Utlues.APP_ver_code(TwoActivity.this),
                    Utlues.APP_tick());

        }

    }
    private void getDatas(String app_tpye, String id, int code, String tick) {
        String sign = Utlues.getSign(app_tpye, id, code, tick);
        //获得调用接口
        MyServer server = Utlues.getMyServer(Api.POST_URL);
        Log.i("server",server.toString());
        Flowable<FirstHandBean> firstHand = server.getFirstHand(app_tpye, id, code, tick, sign);
        firstHand.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DefaultSubscriber<FirstHandBean>() {
                    @Override
                    public void onNext(FirstHandBean firstHandBean) {
                        //拿到AppKey和Appid
                        String key = firstHandBean.getData().getPrivate_key();
                        String app_key = firstHandBean.getData().getApp_id();
                        Log.i("xxxfoirst--","onNext");
                        Log.i("xxx",key+"->id:"+app_key);
                        //将获得的数据保存起来
                        editor.putString(Api.PRIVATE_KEY,key);
                        editor.putString(Api.APP_ID,app_key);
                        //记录请求
                        editor.putBoolean("two",false);
                        //提交
                        editor.commit();
                        // getTwo(key, app_key, Utlues.APP_dev_id(TwoActivity.this), Utlues.APP_ver_code(TwoActivity.this), Utlues.APP_tick());
                        getTwo(SharedpreferenceUtile.getInstance().getKEY(), SharedpreferenceUtile.getInstance().getID(), Utlues.APP_dev_id(TwoActivity.this), Utlues.APP_ver_code(TwoActivity.this), Utlues.APP_tick());
                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.i("xxxfoirst--","onError");
                        Log.i("xxxxe",t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.i("xxxfoirst--","onComplete");
                    }
                });

    }
    private void getTwo(String key, String id, String dev_id, int code, String tick) {
        String sing = Utlues.getTwoDao(key, id, dev_id, code, tick);
        Log.i("xxkey",key);
        Log.i("xxid",id);
        Log.i("xxdev_id",dev_id);
        Log.i("xxcode",code+"");
        Log.i("xxtick",tick);
        Log.i("xxsing",sing);
        //获得调用接口
        MyServer server = Utlues.getMyServer(Api.POST_URL);
        Flowable<TwoHandBean> twoHand = server.getTwoHand(id, dev_id, code, tick, sing);
        twoHand.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DefaultSubscriber<TwoHandBean>() {
                    @Override
                    public void onNext(TwoHandBean twoHandBean) {
                        Log.i("xxx","onNext");
                        String url_host = twoHandBean.getData().getUrl_host();
                        Log.i("url",url_host);
                        editor.putString(Api.BASE_URL3,url_host);
                        editor.putBoolean("two",true);
                        editor.commit();
                        getFragment();

                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.i("xxx","onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.i("xxx","onComplete");
                    }
                });
    }



    @Override
    public void getData() {
     /*   course_f = new Course_f();
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
        yMine.setSelected(false);*/
    }
    public void getFragment(){
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

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
