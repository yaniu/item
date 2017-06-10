package com.example.administrator.yn_yuzhilai.tools;


import com.example.administrator.yn_yuzhilai.bean.CallBean;
import com.example.administrator.yn_yuzhilai.bean.CateGroyBean;
import com.example.administrator.yn_yuzhilai.bean.FirstHandBean;
import com.example.administrator.yn_yuzhilai.bean.JingBean;
import com.example.administrator.yn_yuzhilai.bean.KeBean;
import com.example.administrator.yn_yuzhilai.bean.MaBean;
import com.example.administrator.yn_yuzhilai.bean.OneJingBean;
import com.example.administrator.yn_yuzhilai.bean.OneKeBean;
import com.example.administrator.yn_yuzhilai.bean.OneMianBean;
import com.example.administrator.yn_yuzhilai.bean.OnePicBean;
import com.example.administrator.yn_yuzhilai.bean.RegBean;
import com.example.administrator.yn_yuzhilai.bean.ShouBean;
import com.example.administrator.yn_yuzhilai.bean.ShouLieBean;
import com.example.administrator.yn_yuzhilai.bean.TwoHandBean;
import com.example.administrator.yn_yuzhilai.bean.User_LoginBean;
import com.example.administrator.yn_yuzhilai.bean.ZhuBean;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * 作者：仝晓雅 on 2017/5/25 15:37
 * 类的注释：定义接口
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
   @POST("/app/v1/first_hand")
   @FormUrlEncoded
   Flowable<FirstHandBean> getFirstHand(@Field("type") String type, @Field("dev_id") String id
           , @Field("ver_code") int code, @Field("tick") String tick
           , @Field("sign") String sign);

    /**
     *FirstHand 连接导向
     *
     */
    @POST("/app/v1/get_host")
    @FormUrlEncoded
    Flowable<TwoHandBean> getTwoHand(@Field("app_id") String app_id, @Field("dev_id") String id
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
    @POST("/app/v1/list_banner")
    @FormUrlEncoded
    Flowable<OnePicBean> getListBanner(@Field("app_id") String appId, @Field("dev_id") String dev_id,
                                       @Field("ver_code") int ver_code, @Field("tick") String tick,
                                       @Field("sign") String sign);

   //获取试听课列表
    @POST("/app/v1/list_try")
    @FormUrlEncoded
    Flowable<OneMianBean> getMianList(@Field("app_id") String appId, @Field("dev_id") String dev_id,
                                      @Field("ver_code") int ver_code, @Field("tick") String tick,
                                      @Field("page_size") int page_size, @Field("page_index") int page_index,
                                      @Field("sign") String sign);

    //精选课程
    @POST("/app/v1/list_course")
    @FormUrlEncoded
    Flowable<OneKeBean> getKeList(@Field("app_id") String appId, @Field("dev_id") String dev_id,
                                  @Field("ver_code") int ver_code, @Field("tick") String tick,
                                  @Field("page_size") int page_size, @Field("page_index") int page_index,
                                  @Field("sign") String sign);
    //精选专辑
   @POST("/app/v1/list_topic")
    @FormUrlEncoded
   Flowable<OneJingBean> getJingList(@Field("app_id") String appId, @Field("dev_id") String dev_id,
                                     @Field("ver_code") int ver_code, @Field("tick") String tick,
                                     @Field("page_size") int page_size, @Field("page_index") int page_index,
                                     @Field("sign") String sign);
    //精选专辑详情界面
    @POST("/app/v1/detail_topic")
    @FormUrlEncoded
    Flowable<JingBean> getJingList_xiang(@Field("app_id") String appId, @Field("dev_id") String dev_id,
                                         @Field("ver_code") int ver_code, @Field("tick") String tick,
                                         @Field("object_id") int object_id,
                                         @Field("sign") String sign);
    //精选课程详情界面
    @POST("/app/v1/detail_course")
    @FormUrlEncoded
    Flowable<KeBean> getKeList_xiang(@Field("app_id") String appId, @Field("dev_id") String dev_id,
                                     @Field("ver_code") int ver_code, @Field("tick") String tick,
                                     @Field("object_id") int object_id,
                                     @Field("sign") String sign);
    //注册界面
    @POST("/app/v1/user_reg")
    @FormUrlEncoded
    Flowable<RegBean> getReg(@Field("app_id") String appId, @Field("dev_id") String dev_id,
                             @Field("ver_code") int ver_code, @Field("tick") String tick,
                             @Field("mobile") String mobile,
                             @Field("sign") String sign);
    //核对验证码
    @POST("/app/v1/user_check_rand")
    @FormUrlEncoded
    Flowable<MaBean> getMa(@Field("app_id") String appId, @Field("dev_id") String dev_id,
                           @Field("ver_code") int ver_code, @Field("tick") String tick,
                           @Field("session") String session, @Field("rand") String rand,
                           @Field("passwd") String passwd,
                           @Field("sign") String sign);

 //登录
 @POST("/app/v1/user_pwd_login")
 @FormUrlEncoded
 Flowable<User_LoginBean> getLog(@Field("app_id") String appId, @Field("dev_id") String dev_id,
                                 @Field("ver_code") int ver_code, @Field("tick") String tick,
                                 @Field("mobile") String mobile, @Field("passwd") String passwd,
                                 @Field("sign") String sign);
   //课程分类的Tab
    @POST("/app/v1/list_category")
    @FormUrlEncoded
    Flowable<CateGroyBean> getCate(@Field("app_id") String appId, @Field("dev_id") String dev_id,
                                   @Field("ver_code") int ver_code, @Field("tick") String tick,
                                   @Field("sign") String sign);
 //收藏

 @POST("/app/v1/heart_object")
 @FormUrlEncoded
 Flowable<ShouBean> getShou(@Field("app_id") String appId, @Field("dev_id") String dev_id,
                            @Field("ver_code") int ver_code, @Field("tick") String tick,
                            @Field("session") String session, @Field("object_id") int object_id,
                            @Field("sign") String sign);
 //收藏列表

 @POST("/app/v1/heart_list")
 @FormUrlEncoded
 Flowable<ShouLieBean> getShouLie(@Field("app_id") String appId, @Field("dev_id") String dev_id,
                                  @Field("ver_code") int ver_code, @Field("tick") String tick,
                                  @Field("session") String session,
                                  @Field("sign") String sign);
 //获取个人信息
 @POST("/app/v1/personal_info")
 @FormUrlEncoded
 Flowable<ShouLieBean> getHuoLie(@Field("app_id") String appId, @Field("dev_id") String dev_id,
                                  @Field("ver_code") int ver_code, @Field("tick") String tick,
                                  @Field("session") String session,
                                  @Field("sign") String sign);
 //获取客服信息
 @POST("/app/v1/cs_info")
 @FormUrlEncoded
 Flowable<CallBean> getKeLie(@Field("app_id") String appId, @Field("dev_id") String dev_id,
                             @Field("ver_code") int ver_code, @Field("tick") String tick,
                             @Field("session") String session,
                             @Field("sign") String sign);

 //注销客户
 @POST("/app/v1/user_logout")
 @FormUrlEncoded
 Flowable<ZhuBean> getZhu(@Field("app_id") String appId, @Field("dev_id") String dev_id,
                          @Field("ver_code") int ver_code, @Field("tick") String tick,
                          @Field("session") String session,
                          @Field("sign") String sign);

}
