package com.example.administrator.yn_itme_x.apdate;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.yn_itme_x.R;
import com.example.administrator.yn_itme_x.bean.JingBean;

import java.util.List;

/**
 * 作者：仝晓雅 on 2017/5/26 19:44
 * 类的注释：
 */

public class Study_rec_zhuan_x extends RecyclerView.Adapter<Study_rec_zhuan_x.ViewHolder> {
    private Context context;
    private List<JingBean.DataBean.CourseBean> course;
    public Study_rec_zhuan_x(Context context, List<JingBean.DataBean.CourseBean> course) {
        this.context =context;
        this.course =course;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.study_rec_ke, parent,false);
     ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.rec_text1.setText(course.get(position).getTitle());
        holder.rec_text2.setText(course.get(position).getTitle2());
        holder.rec_text3.setText(course.get(position).getSpeaker());
        holder.rec_text4.setText("￥："+course.get(position).getPrice());
        holder.rec_text5.setText("已售 ："+course.get(position).getLength()+"");


        Glide.with(context).load(course.get(position).getImage()).into(holder.rec_pic);
    }

    @Override
    public int getItemCount() {
        return course.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView rec_pic;
        private TextView rec_text1;
        private TextView rec_text2;
        private TextView rec_text3;
        private TextView rec_text4;
        private TextView rec_text5;

        public ViewHolder(View itemView) {
            super(itemView);
            rec_pic = (ImageView) itemView.findViewById(R.id.rec_pic_ke);
            rec_text1 = (TextView) itemView.findViewById(R.id.rec_text1_ke);
            rec_text2 = (TextView) itemView.findViewById(R.id.rec_text2_ke);
            rec_text3 = (TextView) itemView.findViewById(R.id.rec_text3_ke);
            rec_text4 = (TextView) itemView.findViewById(R.id.rec_text4_ke);
            rec_text5 = (TextView) itemView.findViewById(R.id.rec_text5_ke);




        }
    }
}
