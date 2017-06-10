package com.example.administrator.yn_yuzhilai.bean;

/**
 * 类的用途：
 * 作者：dell
 * 时间： 2017/6/5 14:44
 */

public class User_LoginBean {
    public Data data;
    public int ret;

    public  class  Data{
        public boolean alert;
        public String message;
        public String session;
        public String session_id;
        public int user_role;

        @Override
        public String toString() {
            return "Data{" +
                    "alert=" + alert +
                    ", message='" + message + '\'' +
                    ", session='" + session + '\'' +
                    ", session_id='" + session_id + '\'' +
                    ", user_role=" + user_role +
                    '}';
        }
    }
}
