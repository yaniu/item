package com.example.administrator.yn_yuzhilai.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.administrator.yn_yuzhilai.R;
import com.example.administrator.yn_yuzhilai.activity.ChongActivity;
import com.example.administrator.yn_yuzhilai.activity.LogActivity;
import com.example.administrator.yn_yuzhilai.bean.XiuBean;
import com.example.administrator.yn_yuzhilai.mine.GouActivity;
import com.example.administrator.yn_yuzhilai.mine.KeActivity;
import com.example.administrator.yn_yuzhilai.mine.SheActivity;
import com.example.administrator.yn_yuzhilai.mine.ShouActivity;
import com.example.administrator.yn_yuzhilai.mine.VIPActivity;
import com.example.administrator.yn_yuzhilai.mine.XiaActivity;
import com.example.administrator.yn_yuzhilai.mine.XiaoActivity;
import com.example.administrator.yn_yuzhilai.mine.XiuActivity;
import com.example.administrator.yn_yuzhilai.tools.SharedpreferenceUtile;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者：仝晓雅 on 2017/5/23 18:53
 * 类的注释：我的界面
 */

public class Mine_f extends Fragment {

    @Bind(R.id.i_fan)
    ImageView iFan;
    @Bind(R.id.i_text)
    TextView iText;
    @Bind(R.id.m_pic)
    ImageView mPic;
    @Bind(R.id.m_name)
    TextView mName;
    @Bind(R.id.m_name2)
    TextView mName2;
    @Bind(R.id.m_pic1)
    ImageView mPic1;
    @Bind(R.id.m_lin)
    LinearLayout mLin;
    @Bind(R.id.m_xia)
    LinearLayout mXia;
    @Bind(R.id.m_shou)
    LinearLayout mShou;
    @Bind(R.id.m_yu)
    LinearLayout mYu;
    @Bind(R.id.m_gou)
    LinearLayout mGou;
    @Bind(R.id.m_xiao)
    LinearLayout mXiao;
    @Bind(R.id.m_vip)
    LinearLayout mVip;
    @Bind(R.id.m_she)
    LinearLayout mShe;
    @Bind(R.id.m_phone)
    LinearLayout mPhone;
    @Bind(R.id.scro)
    ScrollView scro;
    private boolean login_boolean;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.m_main, null);
        //EventBus进行注册
        EventBus.getDefault().register(this);
        ButterKnife.bind(this, view);
        iText.setText("我的");

        return view;
    }
    @OnClick({
            R.id.i_fan,
            R.id.i_text,
            R.id.m_pic,
            R.id.m_name,
            R.id.m_name2,
            R.id.m_pic1,
            R.id.m_lin,
            R.id.m_xia,
            R.id.m_shou,
            R.id.m_yu,
            R.id.m_gou,
            R.id.m_xiao,
            R.id.m_vip,
            R.id.m_she,
            R.id.m_phone,
            R.id.scro})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.i_fan:
                break;
            case R.id.i_text:
                break;
            case R.id.m_pic:
                Toast.makeText(getActivity(), "头像", Toast.LENGTH_SHORT).show();
                break;
            case R.id.m_name:
                Intent intent0 =new Intent(getActivity(),XiuActivity.class);
                startActivityForResult(intent0,100);
                break;
            case R.id.m_name2:
                break;
            case R.id.m_pic1:

                break;
            case R.id.m_lin:

                Intent intent =new Intent(getActivity(), LogActivity.class);
                intent.putExtra("position",2);

                startActivityForResult(intent,100);
                //startActivity(intent);
                break;
            case R.id.m_xia:
                Intent intent1 =new Intent(getActivity(), XiaActivity.class);
                startActivityForResult(intent1,200);
                break;
            case R.id.m_shou:
                SharedPreferences sh = SharedpreferenceUtile.getInstance().getSh();
                login_boolean = sh.getBoolean("login_boolean", false);
                //如果没有登录过就先登录
               if(login_boolean){
                   Intent intent2 =new Intent(getActivity(), ShouActivity.class);
                   startActivityForResult(intent2,200);
               }else{
                   Toast.makeText(getActivity(), "主人，请先登录哈~~么么哒！", Toast.LENGTH_SHORT).show();
               }
                break;
            case R.id.m_yu:
                Intent intent3 =new Intent(getActivity(), ChongActivity.class);
                startActivityForResult(intent3,200);
                break;
            case R.id.m_gou:
                Intent intent4 =new Intent(getActivity(), GouActivity.class);
                startActivityForResult(intent4,200);
                break;
            case R.id.m_xiao:
                Intent intent5 =new Intent(getActivity(), XiaoActivity.class);
                startActivityForResult(intent5,200);
                break;
            case R.id.m_vip:
                Intent intent6 =new Intent(getActivity(), VIPActivity.class);
                startActivityForResult(intent6,200);
                break;
            case R.id.m_she:
                Intent intent7 =new Intent(getActivity(), SheActivity.class);
                startActivityForResult(intent7,200);
                break;
            case R.id.m_phone:
                /*Intent intent8 =new Intent(getActivity(), KeActivity.class);
                startActivityForResult(intent8,100);*/
                //开始拨打
                Intent intent_p = new Intent();
                intent_p.setAction(Intent.ACTION_CALL); // 隐式意图，指定动作
                intent_p.setData(Uri.parse("tel:"+123456789)); // 带值
                startActivity(intent_p);  //开始调转
                break;
            case R.id.scro:
                break;
        }

    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getEveBus(XiuBean xiuBean){
        mName.setText(xiuBean.name);
        mName2.setText(xiuBean.name1);
        String url = xiuBean.url;
       // Glide.with(getActivity()).load(url).asBitmap().centerCrop().into(mPic);
        Glide.with(getActivity()).load(url).asBitmap().centerCrop().into(new BitmapImageViewTarget(mPic)
        {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(getActivity().getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                mPic.setImageDrawable(circularBitmapDrawable);
            }
        });
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==200&&requestCode==100){
            String name = data.getStringExtra("mname");
            Log.i("name",name);
            mName.setText(name);
        } if(resultCode==300&&requestCode==200){

        }

    }

}
