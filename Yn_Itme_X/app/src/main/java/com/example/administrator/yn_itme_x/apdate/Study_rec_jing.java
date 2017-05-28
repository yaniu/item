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
import com.example.administrator.yn_itme_x.bean.OneJingBean;
import com.example.administrator.yn_itme_x.bean.OneKeBean;

import java.util.List;

/**
 * 作者：仝晓雅 on 2017/5/24 09:24
 * 类的注释：学习界面里的条目展示(精选专辑)
 */

public class Study_rec_jing extends RecyclerView.Adapter<Study_rec_jing.ViewHolder> {
    private Context context;
    private List<OneJingBean.DataBean.TopicBean>  mian_list;


    //①新建内部接口：
    public interface OnItemClickListener{
        void onItemClick(View view,int position);
    }
    //②新建私有接口变量用于保存用户设置的监听器及其set方法：
    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener){
        this.mOnItemClickListener = mOnItemClickListener;
    }
    public Study_rec_jing(Context context, List<OneJingBean.DataBean.TopicBean> topic) {
        this.context = context;
        this.mian_list =topic;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.study_rec_jing, parent,false);
        final ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.rec_text1.setText(mian_list.get(position).getTitle());
        holder.rec_text2.setText(mian_list.get(position).getTitle2());
        holder.rec_text6.setText(mian_list.get(position).getObject_id()+"");
        holder.rec_text4.setText(mian_list.get(position).getLength()+" 堂课");
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
        private TextView rec_text6;
        private TextView rec_text4;
        private final LinearLayout lin;

        public ViewHolder(View itemView) {
            super(itemView);
            rec_pic = (ImageView) itemView.findViewById(R.id.rec_pic_jing);
            rec_text1 = (TextView) itemView.findViewById(R.id.rec_text1_jing);
            rec_text2 = (TextView) itemView.findViewById(R.id.rec_text2_jing);
            rec_text6 = (TextView) itemView.findViewById(R.id.rec_text6_jing);
            rec_text4 = (TextView) itemView.findViewById(R.id.rec_text4_jing);
            lin = (LinearLayout) itemView.findViewById(R.id.rec_lin_jing);

        }
    }
}
