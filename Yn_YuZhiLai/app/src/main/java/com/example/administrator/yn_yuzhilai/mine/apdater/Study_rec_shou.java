package com.example.administrator.yn_yuzhilai.mine.apdater;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.yn_yuzhilai.R;
import com.example.administrator.yn_yuzhilai.bean.ShouLieBean;

import java.util.List;


/**
 * 作者：仝晓雅 on 2017/5/24 09:24
 * 类的注释：学习界面里的条目展示（精选课程）
 */

public class Study_rec_shou extends RecyclerView.Adapter<Study_rec_shou.ViewHolder> {
    private Context context;
    private  List<ShouLieBean.DataBean.HeartBean> heart;

    public Study_rec_shou(Context context, List<ShouLieBean.DataBean.HeartBean> heart) {
        this.context =context;
        this.heart =heart;
    }

    //①新建内部接口：
    public interface OnItemClickListener{
        void onItemClick(View view, int position);
    }
    //②新建私有接口变量用于保存用户设置的监听器及其set方法：
    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener){
        this.mOnItemClickListener = mOnItemClickListener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rec_shou, parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.rec_text1.setText(heart.get(position).getTitle());
        holder.rec_text4.setText("已播 ："+heart.get(position).getLength()+"");

        Glide.with(context).load(heart.get(position).getImage()).into(holder.rec_pic);
         holder.lin.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if(mOnItemClickListener!=null){
                     String object_id = heart.get(position).getObject_id();
                     int parseInt = Integer.parseInt(object_id);
                     mOnItemClickListener.onItemClick(v,parseInt);
                 }
             }
         });
    }

    @Override
    public int getItemCount() {

        return heart.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView rec_pic;
        private TextView rec_text1;
        private TextView rec_text2;
        private TextView rec_text3;
        private TextView rec_text4;
        private  LinearLayout lin;

        public ViewHolder(View itemView) {
            super(itemView);
            rec_pic = (ImageView) itemView.findViewById(R.id.srec_pic);
            rec_text1 = (TextView) itemView.findViewById(R.id.srec_text1);
            rec_text2 = (TextView) itemView.findViewById(R.id.srec_text2);
            rec_text3 = (TextView) itemView.findViewById(R.id.srec_text3);
            rec_text4 = (TextView) itemView.findViewById(R.id.srec_text4);
            lin = (LinearLayout) itemView.findViewById(R.id.srec_lin);



        }
    }
}
