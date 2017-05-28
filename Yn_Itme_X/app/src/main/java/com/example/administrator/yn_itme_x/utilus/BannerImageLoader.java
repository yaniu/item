package com.example.administrator.yn_itme_x.utilus;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;

/**
 * Use:Banner图片加载类
 * Author:陈懿鹏
 * Data:2017/5/25.
 */

public class BannerImageLoader  extends ImageLoader{
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        //Glide 加载图片简单用法
        Glide.with(context).load(path).into(imageView);
    }
}
