package com.example.administrator.yn_yuzhilai.bean;

/**
 * 作者：仝晓雅 on 2017/6/2 15:44
 * 类的注释：
 */

public class TwoHandBean {

    /**
     * data : {"url_host":"https://pretty.f8cam.com:17213"}
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
         * url_host : https://pretty.f8cam.com:17213
         */

        private String url_host;

        public String getUrl_host() {
            return url_host;
        }

        public void setUrl_host(String url_host) {
            this.url_host = url_host;
        }
    }
}
