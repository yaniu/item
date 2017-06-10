package com.example.administrator.yn_yuzhilai.bean;

/**
 * 作者：仝晓雅 on 2017/6/8 21:07
 * 类的注释：
 */

public class ZhuBean {

    /**
     * data : {"logout":true}
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
         * logout : true
         */

        private boolean logout;

        public boolean isLogout() {
            return logout;
        }

        public void setLogout(boolean logout) {
            this.logout = logout;
        }
    }
}
