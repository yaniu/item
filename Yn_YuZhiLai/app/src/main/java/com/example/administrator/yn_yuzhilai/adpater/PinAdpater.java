package com.example.administrator.yn_yuzhilai.adpater;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.yn_yuzhilai.R;

/**
 * 作者：仝晓雅 on 2017/6/5 19:06
 * 类的注释：
 */

public class PinAdpater extends RecyclerView.Adapter<PinAdpater.ViewHolder> {
    private  Context contect;
    public PinAdpater(Context contect) {
        this.contect=contect;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(contect).inflate(R.layout.pin_main, parent,false);
        ViewHolder holder =new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
