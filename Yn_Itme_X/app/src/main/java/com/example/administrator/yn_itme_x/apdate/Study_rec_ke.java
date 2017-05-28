package com.example.administrator.yn_itme_x.apdate;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.yn_itme_x.R;
import com.example.administrator.yn_itme_x.bean.OneKeBean;
import com.example.administrator.yn_itme_x.bean.OneMianBean;

import java.util.List;

/**
 * 作者：仝晓雅 on 2017/5/24 09:24
 * 类的注释：学习界面里的条目展示（精选课程）
 */

public class Study_rec_ke extends RecyclerView.Adapter<Study_rec_ke.ViewHolder> {
    private Context context;
    private List<OneKeBean.DataBean.CourseBean> mian_list;
    //①新建内部接口：
    public interface OnItemClickListener{
        void onItemClick(View view,int position);
    }
    //②新建私有接口变量用于保存用户设置的监听器及其set方法：
    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener){
        this.mOnItemClickListener = mOnItemClickListener;
    }
    public Study_rec_ke(Context context, List<OneKeBean.DataBean.CourseBean> course) {
        this.context = context;
        this.mian_list =course;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.study_rec_ke, parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.rec_text1.setText(mian_list.get(position).getTitle());
        holder.rec_text2.setText(mian_list.get(position).getTitle2());
        holder.rec_text3.setText(mian_list.get(position).getSpeaker());
        holder.rec_text4.setText("￥："+mian_list.get(position).getPrice());
        holder.rec_text5.setText("已售 ："+mian_list.get(position).getLength()+"");


        Glide.with(context).load(mian_list.get(position).getImage()).into(holder.rec_pic);
        holder.lin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mOnItemClickListener!=null){
                    int parseInt = Integer.parseInt(mian_list.get(position).getObject_id());
                    mOnItemClickListener.onItemClick(v,parseInt);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mian_list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView rec_pic;
        private TextView rec_text1;
        private TextView rec_text2;
        private TextView rec_text3;
        private TextView rec_text4;
        private TextView rec_text5;

        private final LinearLayout lin;

        public ViewHolder(View itemView) {
            super(itemView);
            rec_pic = (ImageView) itemView.findViewById(R.id.rec_pic_ke);
            rec_text1 = (TextView) itemView.findViewById(R.id.rec_text1_ke);
            rec_text2 = (TextView) itemView.findViewById(R.id.rec_text2_ke);
            rec_text3 = (TextView) itemView.findViewById(R.id.rec_text3_ke);
            rec_text4 = (TextView) itemView.findViewById(R.id.rec_text4_ke);
            rec_text5 = (TextView) itemView.findViewById(R.id.rec_text5_ke);

            lin = (LinearLayout) itemView.findViewById(R.id.rec_lin_ke);



        }
    }
}
