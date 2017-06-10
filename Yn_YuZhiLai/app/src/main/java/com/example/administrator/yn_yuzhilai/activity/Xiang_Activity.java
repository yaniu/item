package com.example.administrator.yn_yuzhilai.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.administrator.yn_yuzhilai.R;
import com.example.administrator.yn_yuzhilai.adpater.PinAdpater;
import com.example.administrator.yn_yuzhilai.bean.CallBean;
import com.example.administrator.yn_yuzhilai.bean.JingBean;
import com.example.administrator.yn_yuzhilai.bean.KeBean;
import com.example.administrator.yn_yuzhilai.bean.ShouBean;
import com.example.administrator.yn_yuzhilai.bean.ShouLieBean;
import com.example.administrator.yn_yuzhilai.bean.ZhuBean;
import com.example.administrator.yn_yuzhilai.mine.XiaActivity;
import com.example.administrator.yn_yuzhilai.mine.XiuActivity;
import com.example.administrator.yn_yuzhilai.mine.shou_mvp.Shou_View;
import com.example.administrator.yn_yuzhilai.tools.MyServer;
import com.example.administrator.yn_yuzhilai.tools.RecyclerViewDivider;
import com.example.administrator.yn_yuzhilai.tools.SharedpreferenceUtile;
import com.example.administrator.yn_yuzhilai.tools.Utlues;
import com.example.administrator.yn_yuzhilai.x_mvp.persenter.X_MyPersenter;
import com.example.administrator.yn_yuzhilai.x_mvp.view.X_View;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DefaultSubscriber;

/**
 * 作者：仝晓雅 on 2017/6/3 11:28
 * 类的注释：
 */

public class Xiang_Activity extends Activity implements X_View,Shou_View{

    @Bind(R.id.k_x_fan)
    ImageView kXFan;
    @Bind(R.id.k_x_name)
    TextView kXName;
    @Bind(R.id.k_x_fen)
    ImageView kXFen;
    @Bind(R.id.k_x_jc)
    JCVideoPlayerStandard kXJc;
    @Bind(R.id.k_x_name2)
    TextView kXName2;
    @Bind(R.id.k_x_mai)
    TextView kXMai;
    @Bind(R.id.k_x_tou)
    ImageView kXTou;
    @Bind(R.id.k_x_text1)
    TextView kXText1;
    @Bind(R.id.k_x_text2)
    TextView kXText2;
    @Bind(R.id.k_x_teacher)
    TextView kXTeacher;
    @Bind(R.id.k_x_neirong)
    TextView kXNeirong;
    @Bind(R.id.k_x_rec)
    RecyclerView kXRec;
    @Bind(R.id.k_x_soll)
    NestedScrollView kXSoll;
    @Bind(R.id.k_x_phone)
    RadioButton kXPhone;
    @Bind(R.id.k_x_shou)
    RadioButton kXShou;
    @Bind(R.id.k_x_xia)
    RadioButton kXXia;
    @Bind(R.id.k_x_pingjia)
    TextView kXPingjia;
    @Bind(R.id.k_x_num)
    TextView kXNum;
    boolean falg =false;
    private int posotion;
    private boolean login_boolean;
   // private ArrayList<String> list;
    private int price;
    private   String number;
    private String mai;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xiang_j);
        ButterKnife.bind(this);
        changeImageSize();
        Intent intent =getIntent();
        posotion = intent.getIntExtra("position", -1);
        falg= intent.getBooleanExtra("flag", false);
        price = intent.getIntExtra("price", 1);
        mai = intent.getStringExtra("mai");
        kXMai.setText(mai);

        X_MyPersenter x_myPersenter =new X_MyPersenter(this,this);
        x_myPersenter.getXiang(posotion);
        //添加分割线
        kXRec.addItemDecoration(new RecyclerViewDivider(
                this, RecyclerViewDivider.VERTICAL_LIST));
        kXRec.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        PinAdpater pin =new PinAdpater(Xiang_Activity.this);
        kXRec.setAdapter(pin);
        SharedPreferences sh = SharedpreferenceUtile.getInstance().getSh();
        login_boolean = sh.getBoolean("login_boolean", false);
      //  list = new ArrayList<>();
        if(falg==true){
            kXShou.setTextColor(Color.YELLOW);
        }
    }

    @OnClick({R.id.k_x_fan, R.id.k_x_name, R.id.k_x_fen, R.id.k_x_jc, R.id.k_x_name2, R.id.k_x_mai, R.id.k_x_tou, R.id.k_x_text1, R.id.k_x_text2, R.id.k_x_teacher, R.id.k_x_neirong, R.id.k_x_rec, R.id.k_x_soll, R.id.k_x_phone, R.id.k_x_shou, R.id.k_x_xia, R.id.k_x_pingjia})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.k_x_fan:
                Intent in = new Intent();
                Xiang_Activity.this.setResult(30, in);
                finish();
                break;
            case R.id.k_x_name:
                break;
            case R.id.k_x_fen:
                break;
            case R.id.k_x_jc:
                break;
            case R.id.k_x_name2:
                break;
            case R.id.k_x_mai:
                if(login_boolean){
                    Intent intent =new Intent(Xiang_Activity.this,ZhiFuActivity.class);
                    intent.putExtra("jiage",price);
                    startActivity(intent);
                }else{
                    Intent intent =new Intent(Xiang_Activity.this,LogActivity.class);
                    intent.putExtra("position",1);
                    startActivityForResult(intent,1);
                    //startActivity(intent);
                }
                break;
            case R.id.k_x_tou:
                break;
            case R.id.k_x_text1:
                break;
            case R.id.k_x_text2:
                break;
            case R.id.k_x_teacher:
                break;
            case R.id.k_x_neirong:
                break;
            case R.id.k_x_rec:
                break;
            case R.id.k_x_soll:
                break;
            case R.id.k_x_phone:
               /* Intent intent_p =new Intent();
                intent_p.setAction(Intent.ACTION_DIAL);

                intent_p.addCategory(Intent.CATEGORY_DEFAULT);
                startActivity(intent_p);*/
                //注意权限的使用
                //<!-- 获取拨打电话的权限 -->
                //<uses-permission android:name="android.permission.CALL_PHONE" />

                //开始拨打
                Intent intent_p = new Intent();
                intent_p.setAction(Intent.ACTION_CALL); // 隐式意图，指定动作
                intent_p.setData(Uri.parse("tel:"+number)); // 带值
                startActivity(intent_p);  //开始调转
                break;
            case R.id.k_x_shou:
             if(login_boolean==false){
                 Toast.makeText(this, "主人，请先登录哈~~么么哒！", Toast.LENGTH_SHORT).show();
             }else{
                 if(falg){
                     kXShou.setTextColor(Color.BLACK);
                     getData(posotion);
                     Toast.makeText(this, "取消收藏", Toast.LENGTH_SHORT).show();
                 }
                 else{
                     kXShou.setTextColor(Color.YELLOW);
                     getData(posotion);
                     Toast.makeText(Xiang_Activity.this, "收藏成功", Toast.LENGTH_SHORT).show();
                 }
                 falg=!falg;

             }

                break;
            case R.id.k_x_xia:
                Intent intent =new Intent(Xiang_Activity.this, XiaActivity.class);
                startActivity(intent);
                break;
            case R.id.k_x_pingjia:

                break;
            case R.id.k_x_num:
                break;
        }
    }
    private void changeImageSize() {
        //定义底部标签图片大小
        Drawable drawableFirst = getResources().getDrawable(R.mipmap.course_custom);
        drawableFirst.setBounds(0, 0, 25, 25);//第一0是距左右边距离，第二0是距上下边距离，第三69长度,第四宽度
        kXPhone.setCompoundDrawables(null, drawableFirst, null, null);//只放上面

        Drawable drawableSearch = getResources().getDrawable(R.mipmap.course_collection);
        drawableSearch.setBounds(0, 0,25, 25);//第一0是距左右边距离，第二0是距上下边距离，第三69长度,第四宽度
        kXShou.setCompoundDrawables(null, drawableSearch, null, null);//只放上面

        Drawable drawableMe = getResources().getDrawable(R.mipmap.course_download);
        drawableMe.setBounds(0, 0, 25, 25);//第一0是距左右边距离，第二0是距上下边距离，第三69长度,第四宽度
        kXXia.setCompoundDrawables(null, drawableMe, null, null);//只放上面
    }

    private void getData(int object_id) {
        StringBuffer sb =new StringBuffer();
        sb.append(SharedpreferenceUtile.getInstance().getKEY())
                .append(SharedpreferenceUtile.getInstance().getID())
                .append(Utlues.APP_dev_id(this))
                .append(Utlues.APP_ver_code(this))
                .append(Utlues.APP_tick())
                .append(SharedpreferenceUtile.getInstance().getBaseSession())
                .append(object_id);
        Log.i("obji",SharedpreferenceUtile.getInstance().getBaseSession());
        Log.i("objict",object_id+"");
        String string = sb.toString();
        String sing = Utlues.APP_md5(string);
        String sings = sing.toUpperCase();


        MyServer server = Utlues.getMyServer(SharedpreferenceUtile.getInstance().getBase());
        Flowable<ShouBean> shou = server.getShou(SharedpreferenceUtile.getInstance().getID(), Utlues.APP_dev_id(this), Utlues.APP_ver_code(this), Utlues.APP_tick(), SharedpreferenceUtile.getInstance().getBaseSession(), object_id, sings);
        shou.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DefaultSubscriber<ShouBean>() {
                    @Override
                    public void onNext(ShouBean shouBean) {

                        Log.i("shouBean",shouBean.getData().getStatus()+"");




                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }

    @Override
    public void showKeXiang(KeBean keBean) {
        KeBean.DataBean data = keBean.getData();
        kXName.setText(data.getTitle());

        kXText1.setText(data.getTitle());
        kXText2.setText(data.getTitle2());
        //Glide.with(this).load(data.getSpeaker_head()).into(kXTou);
        Glide.with(Xiang_Activity.this).load(data.getSpeaker_head()).asBitmap().centerCrop().into(new BitmapImageViewTarget(kXTou)
        {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(Xiang_Activity.this.getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                kXTou.setImageDrawable(circularBitmapDrawable);
            }
        }
        );
        kXNum.setText("已售：" + data.getTry_length());


        String   video = data.getCourse_video();
        boolean up = kXJc.setUp(video, "啦啦啦拉拉拉拉", "");
        if (up) {
            kXJc.thumbImageView.setImageResource(R.mipmap.course_video);
        }
    }

    @Override
    public void showZhuanXiang(JingBean jingBean) {

    }

    @Override
    public void showShow(ShouLieBean shouLieBean) {
     /*   List<ShouLieBean.DataBean.HeartBean> heart = shouLieBean.getData().getHeart();
        for(int i =0;i<heart.size();i++){
            String object_id = heart.get(i).getObject_id();
            list.add(object_id);
        }*/
    }

    @Override
    public void showCall(CallBean callBean) {
      number  = callBean.getData().getService_tel();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==2&&requestCode==1){
            boolean aBoolean = data.getBooleanExtra("boolean", falg);
            login_boolean=aBoolean;
            Log.i("login",login_boolean+"");
        }
    }
    /*  @Override
    public void showLog(ZhuBean zhuBean) {


    }*/
}
