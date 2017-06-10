package com.example.administrator.yn_yuzhilai.bean;

/**
 * 作者：仝晓雅 on 2017/6/8 16:59
 * 类的注释：
 */

public class CallBean {


    /**
     * data : {"service_tel":"13800000000"}
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
         * service_tel : 13800000000
         */

        private String service_tel;

        public String getService_tel() {
            return service_tel;
        }

        public void setService_tel(String service_tel) {
            this.service_tel = service_tel;
        }
    }
}
