package com.example.administrator.yn_yuzhilai.tools;

import android.content.Context;
import android.media.ImageReader;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;

/**
 * 作者：仝晓雅 on 2017/6/2 08:26
 * 类的注释：
 */

public class MyImager extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        Glide.with(context).load(path).into(imageView);
    }
}
