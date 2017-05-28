package com.example.administrator.yn_itme_x.utilus;

import com.example.administrator.yn_itme_x.bean.FirstHandBean;
import com.example.administrator.yn_itme_x.bean.JingBean;
import com.example.administrator.yn_itme_x.bean.KeBean;
import com.example.administrator.yn_itme_x.bean.OneJingBean;
import com.example.administrator.yn_itme_x.bean.OneKeBean;
import com.example.administrator.yn_itme_x.bean.OneMianBean;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * 作者：仝晓雅 on 2017/5/25 15:37
 * 类的注释：
 */

public interface MyServer {
    /**
     *FirstHand 首次握手
     * @param type app类型 为ANDROID
     * @param id 设备标识
     * @param code 版本号
     * @param tick 时间戳
     * @param sign 签名
     * @return
     */
   @POST("app/v1/first_hand")
   @FormUrlEncoded
   Flowable<FirstHandBean> getFirstHand(@Field("type") String type, @Field("dev_id") String id
                                           , @Field("ver_code") int code, @Field("tick") String tick
                                            , @Field("sign") String sign);


    /**
     * 获得首页轮播图
     * @param appId
     * @param dev_id
     * @param ver_code
     * @param tick
     * @param sign
     * @return
     */
    @POST("app/v1/list_banner")
    @FormUrlEncoded
    Flowable<OnePicBean> getListBanner(@Field("app_id")String appId, @Field("dev_id")String dev_id,
                                       @Field("ver_code")int ver_code, @Field("tick")String tick,
                                       @Field("sign")String sign);

//获取试听课列表
    @POST("app/v1/list_try")
    @FormUrlEncoded
    Flowable<OneMianBean> getMianList(@Field("app_id")String appId, @Field("dev_id")String dev_id,
                                      @Field("ver_code")int ver_code, @Field("tick")String tick,
                                      @Field("page_size") int page_size,@Field("page_index") int page_index,
                                      @Field("sign")String sign);

    //精选课程
    @POST("app/v1/list_course")
    @FormUrlEncoded
    Flowable<OneKeBean> getKeList(@Field("app_id")String appId, @Field("dev_id")String dev_id,
                                    @Field("ver_code")int ver_code, @Field("tick")String tick,
                                    @Field("page_size") int page_size, @Field("page_index") int page_index,
                                   @Field("sign")String sign);
    //精选专辑
   @POST("app/v1/list_topic")
    @FormUrlEncoded
   Flowable<OneJingBean> getJingList(@Field("app_id")String appId, @Field("dev_id")String dev_id,
                                     @Field("ver_code")int ver_code, @Field("tick")String tick,
                                     @Field("page_size") int page_size, @Field("page_index") int page_index,
                                     @Field("sign")String sign);
    //精选专辑详情界面
    @POST("app/v1/detail_topic")
    @FormUrlEncoded
    Flowable<JingBean> getJingList_xiang(@Field("app_id")String appId, @Field("dev_id")String dev_id,
                                   @Field("ver_code")int ver_code, @Field("tick")String tick,
                                    @Field("object_id") int object_id,
                                   @Field("sign")String sign);
    //精选课程详情界面
    @POST("app/v1/detail_course")
    @FormUrlEncoded
    Flowable<KeBean> getKeList_xiang(@Field("app_id")String appId, @Field("dev_id")String dev_id,
                                       @Field("ver_code")int ver_code, @Field("tick")String tick,
                                       @Field("object_id") int object_id,
                                       @Field("sign")String sign);

}
