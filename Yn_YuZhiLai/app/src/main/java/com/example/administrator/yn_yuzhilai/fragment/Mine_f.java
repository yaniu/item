package com.example.administrator.yn_yuzhilai.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AlertDialog;
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
import com.example.administrator.yn_yuzhilai.tools.Utils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.File;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.app.Activity.RESULT_OK;

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
    protected static final int CHOOSE_PICTURE = 0;
    protected static final int TAKE_PICTURE = 1;
    private static final int CROP_SMALL_PICTURE = 2;
    private static final int REQUESTCODE_PICK =1 ;
    protected static Uri tempUri;
    private boolean falg =false;


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
               if(login_boolean){
                   //点击头像进行拍照，或者
                   showChoosePicDialog();
               }else{
                   Toast.makeText(getActivity(), "主人，请先登录哈~~~", Toast.LENGTH_SHORT).show();
               }
                break;
            case R.id.m_name:
                if(login_boolean){
                    Intent intent0 =new Intent(getActivity(),XiuActivity.class);
                    startActivityForResult(intent0,111);
                }else{
                    Toast.makeText(getActivity(), "主人，请先登录哈~~", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.m_name2:
                break;
            case R.id.m_pic1:

                break;
            case R.id.m_lin:
                Intent intent =new Intent(getActivity(), LogActivity.class);
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
    /**
     * 显示修改头像的对话框
     */
    protected void showChoosePicDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("设置头像");
        String[] items = { "选择本地照片", "拍照" };
        builder.setNegativeButton("取消", null);
        builder.setItems(items, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case CHOOSE_PICTURE: // 选择本地照片
                        Intent pickIntent = new Intent(Intent.ACTION_PICK, null);
                        // 如果朋友们要限制上传到服务器的图片类型时可以直接写如：image/jpeg 、 image/png等的类型
                        pickIntent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/png");
                        startActivityForResult(pickIntent, REQUESTCODE_PICK);
                        break;
                    case TAKE_PICTURE: // 拍照
                        Intent openCameraIntent = new Intent(
                                MediaStore.ACTION_IMAGE_CAPTURE);
                        tempUri = Uri.fromFile(new File(Environment
                                .getExternalStorageDirectory(), "image.jpg"));
                        // 指定照片保存路径（SD卡），image.jpg为一个临时文件，每次拍照后这个图片都会被替换
                        openCameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, tempUri);
                        startActivityForResult(openCameraIntent, TAKE_PICTURE);
                        break;
                }
            }
        });
        builder.create().show();
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) { // 如果返回码是可以用的
            switch (requestCode) {
                case TAKE_PICTURE:
                    startPhotoZoom(tempUri); // 开始对图片进行裁剪处理
                    break;
                case CHOOSE_PICTURE:
                    startPhotoZoom(data.getData()); // 开始对图片进行裁剪处理
                    break;
                case CROP_SMALL_PICTURE:
                    if (data != null) {
                        setImageToView(data); // 让刚才选择裁剪得到的图片显示在界面上
                    }
                    break;
            }
        }
        if(resultCode==200&&requestCode==100){
            String name = data.getStringExtra("mname");
            Log.i("name",name);
            mName.setText(name);

        } if(resultCode==300&&requestCode==200){

        }
        if(requestCode==111&&resultCode==200){
            String name = data.getStringExtra("mname");
            Log.i("name",name);
            mName.setText(name);
        }
        if(requestCode==200&&resultCode==111){
        }
        if(requestCode==100&&resultCode==300){
            String log_name = data.getStringExtra("log_name");
            String log_pic = data.getStringExtra("log_pic");
            mName.setText(log_name);
            Glide.with(getActivity()).load(log_pic).asBitmap().centerCrop().into(new BitmapImageViewTarget(mPic)
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

    }

    /**
     * 裁剪图片方法实现
     *
     * @param uri
     */
    protected void startPhotoZoom(Uri uri) {
        if (uri == null) {
            Log.i("tag", "The uri is not exist.");
        }
        tempUri = uri;
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        // 设置裁剪
        intent.putExtra("crop", "true");
        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // outputX outputY 是裁剪图片宽高
        intent.putExtra("outputX", 150);
        intent.putExtra("outputY", 150);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, CROP_SMALL_PICTURE);
    }

    /**
     * 保存裁剪之后的图片数据
     */
    protected void setImageToView(Intent data) {
        Bundle extras = data.getExtras();
        if (extras != null) {
            Bitmap photo = extras.getParcelable("data");
            photo = Utils.toRoundBitmap(photo, tempUri); // 这个时候的图片已经被处理成圆形的了
            mPic.setImageBitmap(photo);
            uploadPic(photo);
        }
    }

    private void uploadPic(Bitmap bitmap) {
        // 上传至服务器
        // ... 可以在这里把Bitmap转换成file，然后得到file的url，做文件上传操作
        // 注意这里得到的图片已经是圆形图片了
        // bitmap是没有做个圆形处理的，但已经被裁剪了

        String imagePath = Utils.savePhoto(bitmap, Environment
                .getExternalStorageDirectory().getAbsolutePath(), String
                .valueOf(System.currentTimeMillis()));
        Log.e("imagePath", imagePath+"");
        if(imagePath != null){
            // 拿着imagePath上传了
            // ...
        }
    }

}
