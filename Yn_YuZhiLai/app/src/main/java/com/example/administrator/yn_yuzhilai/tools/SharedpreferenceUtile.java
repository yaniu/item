package com.example.administrator.yn_yuzhilai.tools;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;

import com.example.administrator.yn_yuzhilai.activity.MainActivity;
import com.example.administrator.yn_yuzhilai.activity.TwoActivity;

/**
 * 作者：仝晓雅 on 2017/6/2 15:13
 * 类的注释：
 */

public class SharedpreferenceUtile {
    private static final SharedpreferenceUtile f = new SharedpreferenceUtile();

    private SharedpreferenceUtile() {}

    public static SharedpreferenceUtile getInstance() {
        return f;
    }

    public SharedPreferences getSh(){
        return TwoActivity.sharedPreferences;
    }

    public String getID(){
        String id = TwoActivity.sharedPreferences.getString(Api.APP_ID, "");
        return id;
    }

    public String getKEY(){
        String key = TwoActivity.sharedPreferences.getString(Api.PRIVATE_KEY, "");
        return key;
    }
    public String getBase(){
        String key =TwoActivity.sharedPreferences.getString(Api.BASE_URL3, "base_url");
        return key;
    }
    public String getBaseSession(){
        String key =TwoActivity.sharedPreferences.getString(Api.SESSION, "");
        return key;
    }

}
