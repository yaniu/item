package com.example.administrator.yn_yuzhilai.mine;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.yn_yuzhilai.R;
import com.example.administrator.yn_yuzhilai.adpater.GouPager;
import com.example.administrator.yn_yuzhilai.tools.RecyclerViewDivider;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者：仝晓雅 on 2017/6/7 08:40
 * 类的注释：
 */

public class GouActivity extends Activity {
    @Bind(R.id.i_fan)
    ImageView iFan;
    @Bind(R.id.i_text)
    TextView iText;
    @Bind(R.id.gou_rec)
    RecyclerView gouRec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.gou_main);
        ButterKnife.bind(this);
        iText.setText("购买记录");
        GouPager gou =new GouPager(this);
        gouRec.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        //添加分割线
        gouRec.addItemDecoration(new RecyclerViewDivider(
                this, RecyclerViewDivider.VERTICAL_LIST));
        gouRec.setAdapter(gou);

    }

    @OnClick({R.id.i_fan, R.id.i_text,R.id.gou_rec})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.i_fan:
                Intent in =new Intent();
                GouActivity.this.setResult(300,in);
                finish();
                break;
            case R.id.i_text:
                break;
            case R.id.gou_rec:
                break;
        }
    }
}
