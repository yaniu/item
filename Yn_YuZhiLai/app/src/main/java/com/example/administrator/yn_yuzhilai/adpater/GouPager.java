package com.example.administrator.yn_yuzhilai.adpater;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.yn_yuzhilai.R;
import com.example.administrator.yn_yuzhilai.mine.GouActivity;

/**
 * 作者：仝晓雅 on 2017/6/8 17:24
 * 类的注释：
 */

public class GouPager extends RecyclerView.Adapter<GouPager.ViewHolder> {

    Context context;
    public GouPager(Context context) {
        this.context=context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rec_gou, parent, false);
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

        private final TextView text1;
        private final TextView text2;
        private final TextView text3;

        public ViewHolder(View itemView) {
            super(itemView);
            text1 = (TextView) itemView.findViewById(R.id.g_r_text1);
            text2 = (TextView) itemView.findViewById(R.id.g_r_text2);
            text3 = (TextView) itemView.findViewById(R.id.g_r_text3);

        }
    }
}
