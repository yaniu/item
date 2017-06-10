package com.example.administrator.yn_yuzhilai.bean;

/**
 * 作者：仝晓雅 on 2017/5/25 15:42
 * 类的注释：
 */

public class FirstHandBean {

    /**
     * data : {"private_key":"41527C9383E46D84074757DF1A3F59ADC457721C","app_id":"JVS3K0YT"}
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
         * private_key : 41527C9383E46D84074757DF1A3F59ADC457721C
         * app_id : JVS3K0YT
         */

        private String private_key;
        private String app_id;

        public String getPrivate_key() {
            return private_key;
        }

        public void setPrivate_key(String private_key) {
            this.private_key = private_key;
        }

        public String getApp_id() {
            return app_id;
        }

        public void setApp_id(String app_id) {
            this.app_id = app_id;
        }
    }
}
