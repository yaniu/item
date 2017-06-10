package com.example.administrator.yn_yuzhilai.mine;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.yn_yuzhilai.R;
import com.example.administrator.yn_yuzhilai.activity.Xiang_Activity;
import com.example.administrator.yn_yuzhilai.activity.Xiang_JActivity;
import com.example.administrator.yn_yuzhilai.adpater.Study_rec_ke;
import com.example.administrator.yn_yuzhilai.bean.CallBean;
import com.example.administrator.yn_yuzhilai.bean.ShouLieBean;
import com.example.administrator.yn_yuzhilai.bean.ZhuBean;
import com.example.administrator.yn_yuzhilai.mine.apdater.Study_rec_shou;
import com.example.administrator.yn_yuzhilai.mine.shou_mvp.Shou_MyPersenter;
import com.example.administrator.yn_yuzhilai.mine.shou_mvp.Shou_View;
import com.example.administrator.yn_yuzhilai.tools.RecyclerViewDivider;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者：仝晓雅 on 2017/6/7 08:40
 * 类的注释：
 */

public class ShouActivity extends Activity implements Shou_View{
    @Bind(R.id.i_fan)
    ImageView iFan;
    @Bind(R.id.i_text)
    TextView iText;
    @Bind(R.id.shou_rec)
    RecyclerView shouRec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shou_main);
        ButterKnife.bind(this);
        iText.setText("我的收藏");
        Shou_MyPersenter shou_myPersenter =new Shou_MyPersenter(this,this);
        shou_myPersenter.showlie();
    }

    @OnClick({R.id.i_fan, R.id.i_text,R.id.shou_rec})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.i_fan:
                Intent in = new Intent();
                ShouActivity.this.setResult(300, in);
                finish();
                break;
            case R.id.i_text:
                break;
            case R.id.shou_rec:
                break;
        }
    }

    @Override
    public void showShow(ShouLieBean shouLieBean) {
        List<ShouLieBean.DataBean.HeartBean> heart = shouLieBean.getData().getHeart();
        Log.i("hhh",heart.size()+"");
        shouRec.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        Study_rec_shou shou =new Study_rec_shou(this,heart);
        //添加分割线
        shouRec.addItemDecoration(new RecyclerViewDivider(
                ShouActivity.this, RecyclerViewDivider.VERTICAL_LIST));
        //点击条目进行跳转到详情界面
         shou.setOnItemClickListener(new Study_rec_shou.OnItemClickListener() {
             @Override
             public void onItemClick(View view, int position) {
                 Intent intent =new Intent(ShouActivity.this,Xiang_Activity.class);
                 intent.putExtra("position",position);
                 intent.putExtra("flag",true);
                startActivity(intent);
             }
         });
        shouRec.setAdapter(shou);
        shou.notifyDataSetChanged();
    }

    @Override
    public void showCall(CallBean callBean) {

    }

   /* @Override
    public void showLog(ZhuBean zhuBean) {

    }*/
}
