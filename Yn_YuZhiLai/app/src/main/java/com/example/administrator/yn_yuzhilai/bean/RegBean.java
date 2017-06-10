package com.example.administrator.yn_yuzhilai.bean;

/**
 * 作者：仝晓雅 on 2017/5/28 11:13
 * 类的注释：注册bean
 */

public class RegBean {


    /**
     * data : {"session":"08cd5bbb7330bac5836342dad3a538ce7b040df5","user_new":true}
     * ret : 0
     */

    private DataBean data;
    private int ret;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public static class DataBean {
        /**
         * session : 08cd5bbb7330bac5836342dad3a538ce7b040df5
         * user_new : true
         */

        private String session;
        private boolean user_new;

        public String getSession() {
            return session;
        }

        public void setSession(String session) {
            this.session = session;
        }

        public boolean isUser_new() {
            return user_new;
        }

        public void setUser_new(boolean user_new) {
            this.user_new = user_new;
        }
    }
}
